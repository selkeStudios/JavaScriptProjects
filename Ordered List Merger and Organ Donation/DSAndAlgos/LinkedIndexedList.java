package DSAndAlgos;

public class LinkedIndexedList <T>
    extends LinkedList<T>
    implements IIndexedList<T>
{
    @Override
    public void add(T element) throws IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        ForwardLinkNode<T> newNode = new ForwardLinkNode<>(element);

        if(count == 0)
        {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }

        ++count;
        ++modCount;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        if(index > count || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        ForwardLinkNode<T> current = head;
        ForwardLinkNode<T> previous = null;

        for(int i = 0; i < index; ++i)
        {
            previous = current;
            current = current.getNext();
        }

        ForwardLinkNode<T> newNode = new ForwardLinkNode<>(element);

        newNode.setNext(current);

        if(previous == null)
        {
            head = newNode;
        } else {
            previous.setNext(newNode);
        }

        if(current == null)
        {
            tail = newNode;
        }

        ++count;
        ++modCount;
    }

    @Override
    public void set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        if(index >= count || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        ForwardLinkNode<T> current = head;
        for(int i = 0; i < index; ++i)
        {
            current = current.getNext();
        }
        current.setElement(element);
        ++modCount;
    }

    @Override
    public T removeAt(int index) throws IndexOutOfBoundsException
    {
        if(index >= count || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        ForwardLinkNode<T> current = head;
        ForwardLinkNode<T> previous = null;

        for(int i = 0; i < index; ++i)
        {
            previous = current;
            current = current.getNext();
        }

        if(previous == null)
        {
            head = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }

        if(current.getNext() == null)
        {
            tail = previous;
        }

        --count;
        ++modCount;

        return current.getElement();
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException
    {
        if(index >= count || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        ForwardLinkNode<T> current = head;

        for(int i = 0; i < index; ++i)
        {
            current = current.getNext();
        }

        return current.getElement();
    }

    @Override
    public int indexOf(T element) throws IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        ForwardLinkNode<T> current = head;

        for(int i = 0; i < count; ++i)
        {
            if(element.equals(current.getElement()))
            {
                return i;
            }
            current = current.getNext();
        }

        return -1;
    }
}

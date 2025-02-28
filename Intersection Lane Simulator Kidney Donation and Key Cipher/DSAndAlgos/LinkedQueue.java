package DSAndAlgos;

public class LinkedQueue<T> implements IQueue<T>
{
    private int count;
    private ForwardLinkNode<T> head; //could be called "front" as well
    private ForwardLinkNode<T> tail; //could be called "rear" as well

    public LinkedQueue()
    {
        count = 0;
        head = tail = null; //The same as  head = null; then, tail = null;
    }

    @Override
    public int size()
    {
        return count;
    }

    @Override
    public boolean isEmpty()
    {
        return count <= 0;
    }

    @Override
    public void enqueue(T element) throws IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        ForwardLinkNode<T> node = new ForwardLinkNode<T>(element);

        if(isEmpty())
        {
            head = node;
        } else {
            tail.setNext(node);
        }

        tail = node;
        ++count;
    }

    @Override
    public T dequeue() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException();
        }

        T result = head.getElement();
        head = head.getNext();
        --count;

        if(isEmpty())
        {
            tail = null;
        }
        return result;
    }

    @Override
    public T first() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException();
        }
        return head.getElement();
    }

    @Override
    public String toString()
    {
        String output = "[ ";

        ForwardLinkNode<T> current = head;
        while(current != null)
        {
            output += current.getElement() + " ";
            current = current.getNext();
        }

        return output + " ] " + "_front = " + head + ", _rear = " + tail + ", _count = " + count;
    }
}

package DSAndAlgos;

public class LinkedStack<T> implements IStack<T>
{
    private int _count;
    private ForwardLinkNode<T> _top;

    public LinkedStack()
    {
        _count = 0;
        _top = null;
    }

    @Override
    public int size()
    {
        return _count;
    }

    @Override
    public boolean isEmpty()
    {
        return _count <= 0;
    }

    @Override
    public void push(T element) throws IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        ForwardLinkNode<T> temp = new ForwardLinkNode<>(element);

        temp.setNext(_top);
        _top = temp;
        ++_count;
    }

    @Override
    public T pop() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException();
        }

        T result = _top.getElement();
        _top = _top.getNext();
        --_count;

        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException();
        }

        return _top.getElement();
    }
}
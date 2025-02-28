package DSAndAlgos;

public class ArrayQueue<T> implements IQueue<T>
{
    private final static int DEFAULT_CAPACITY = 100;

    private int _front;
    private int _rear;
    private int _count;
    private T[] _queue; //_data on 2/14 Quiz!

    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity)
    {
        _front = _rear = _count = 0;
        _queue = (T[]) new Object[initialCapacity];
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
    public void enqueue(T element) throws IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        ensureCapacity();

        _queue[_rear] = element;
        _rear = (_rear + 1) % _queue.length;

        ++_count;
    }

    @Override
    public T dequeue() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException();
        }

        T result = _queue[_front];
        _queue[_front] = null;
        _front = (_front + 1) % _queue.length;

        --_count;

        return result;
    }

    @Override
    public T first() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException();
        }

        return _queue[_front];
    }

    public String toString()
    {
        String output = "[ ";

        int index = _front;
        for(int i = 0; i < _count; ++i)
        {
            output += _queue[index] + " ";
            index = (index + 1) % _queue.length;
        }

        return output + " ] " + "_front = " + _front + ", _rear = " + _rear + ", _count = " + _count;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity()
    {
        if(size() < _queue.length)
        {
            return ;
        }

        T[] larger = (T[]) new Object[_queue.length * 2];

        for(int i = 0; i < _count; ++i)
        {
            larger[i] = _queue[_front];
            _front = (_front + 1) % _queue.length;
        }

        _front = 0;
        _rear = _count;
        _queue = larger;
    }
}

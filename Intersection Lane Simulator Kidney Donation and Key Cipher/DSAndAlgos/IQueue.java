package DSAndAlgos;

public interface IQueue<T> extends ICollection
{
    public void enqueue(T element) throws IllegalArgumentException;

    public T dequeue() throws EmptyCollectionException;

    public T first() throws EmptyCollectionException;
}

package DSAndAlgos;

public interface IStack<T> extends ICollection
{
    public void push(T element) throws IllegalArgumentException;

    public T pop() throws EmptyCollectionException;

    public T peek() throws EmptyCollectionException;
}

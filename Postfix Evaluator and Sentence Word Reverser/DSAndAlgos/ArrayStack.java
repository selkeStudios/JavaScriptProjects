package DSAndAlgos;
import java.util.Arrays;

public class ArrayStack <T> implements IStack<T>
{
    private final static int DEFAULT_CAPACITY = 100;

    private int _top;
    private T[] _stack;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity)
    {
        _top = 0;
        _stack = (T[])new Object[initialCapacity]; //Object = T
    }

    @Override
    public int size() {
        return _top;
    }

    @Override
    public boolean isEmpty() {
        return _top <= 0;
    }

    @Override
    public void push(T element) throws IllegalArgumentException {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        ensureCapacity();

        _stack[_top] = element;
        ++_top;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if(isEmpty())
        {
            throw new EmptyCollectionException();
        }
        --_top;
        T result = _stack[_top];
        _stack[_top] = null;

        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if(isEmpty())
        {
            throw new EmptyCollectionException();
        }
        return _stack[_top - 1];
    }

    private void ensureCapacity()
    {
        if(size() >= _stack.length)
        {
            _stack = Arrays.copyOf(_stack, _stack.length * 2);

            //What ^this^ is actually doing:
            //Integer[] tempStack = new Integer[_stack.length * 2];
            //for(int i = 0; i < _stack.length; ++i) {
            //    tempStack[i] = _stack[i];
            //}
            //_stack = tempStack;
        }
    }

    public T getStack(int stackIndex)
    {
        return _stack[stackIndex];
    }
}
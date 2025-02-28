package DSAndAlgos;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class LinkedList<T> implements IList<T>
{
    protected ForwardLinkNode<T> head;
    protected ForwardLinkNode<T> tail;
    protected int count;
    protected int modCount;

    public LinkedList()
    {
        head = null;
        tail = null;
        count = 0;
        modCount = 0;
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
    public T remove(T element) throws IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        boolean found = false;
        ForwardLinkNode<T> previous = null;
        ForwardLinkNode<T> current = head;

        while(current != null && ! found)
        {
            if(element.equals(current.getElement()))
            {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if(! found)
        {
            return null;
        }

        if(size() == 1)
        {
            head = null;
            tail = null;
        } else if (current.equals(head))
        {
            head = current.getNext();
        } else if (current.equals(tail))
        {
            tail = previous;
            tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }

        --count;
        ++modCount;

        return current.getElement();
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        boolean found = false;
        ForwardLinkNode<T> current = head;

        while(current != null && !found)
        {
            if(element.equals(current.getElement()))
            {
                found = true;
            } else
            {
                current = current.getNext();
            }
        }

        return found;
    }

    public String toString()
    {
        String output = "";

        ForwardLinkNode<T> current = head;
        while(current != null)
        {
            output += current.getElement() + " ";
            current = current.getNext();
        }

        return output;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new LinkedListIterator(this);
    }

    private class LinkedListIterator implements Iterator<T>
    {
        private LinkedList<T> _iteratingList;
        private int initialModCount;
        private ForwardLinkNode<T> current;

        public LinkedListIterator(LinkedList<T> iteratingList)
        {
            _iteratingList = iteratingList;
            initialModCount = iteratingList.modCount;
            current = iteratingList.head;
        }

        public boolean hasNext()
        {
            if(initialModCount != _iteratingList.modCount)
            {
                throw new ConcurrentModificationException();
            }
            return current != null;
        }

        public T next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            T result = current.getElement();
            current = current.getNext();

            return result;
        }
    }
}

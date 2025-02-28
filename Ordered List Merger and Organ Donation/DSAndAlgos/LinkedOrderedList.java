package DSAndAlgos;

public class LinkedOrderedList<T extends Comparable<T>>
        extends LinkedList<T>
        implements IOrderedList<T>
{
    public void add(T element) throws IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }

        ForwardLinkNode<T> newNode = new ForwardLinkNode<>(element);

        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        } else if (element.compareTo(head.getElement()) <= 0)
        {
            newNode.setNext(head);
            head = newNode;
        } else if (element.compareTo(tail.getElement()) >= 0)
        {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            ForwardLinkNode<T> current = head;
            ForwardLinkNode<T> previous = null;

            while(element.compareTo(current.getElement()) > 0)
            {
                previous = current;
                current = current.getNext();
            }

            newNode.setNext(current);
            previous.setNext(newNode);
        }

        ++count;
        ++modCount;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if(isEmpty())
        {
            throw new EmptyCollectionException();
        }

        return head.getElement();
    }
}

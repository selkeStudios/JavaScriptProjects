package DSAndAlgos;

public class EmptyCollectionException extends RuntimeException
{
    private static final long serialVersionUID = 6871384444555469143L;

    public EmptyCollectionException()
    {
        super();
    }

    public EmptyCollectionException(String message)
    {
        super(message);
    }
}
package DSAndAlgos;

public class SearchingEx
{
    public static int linearSearchCount;
    public static int binarySearchCount;

    public static <T> int linearSearch(T[] data, T target)
    {
        return linearSearch(data, target, 0, data.length - 1);
    }

    public static <T> int linearSearch(T[] data, T target, int min, int max)
    {
        if(data == null)
        {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if(target == null)
        {
            throw new IllegalArgumentException("Target cannot be null");
        }

        for(int i = min; i <= max; ++i)
        {
            linearSearchCount++;
            if(target.equals(data[i]))
            {
                return i;
            }
        }

        return -1;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] data, T target)
    {
        return binarySearchChecked(data, target, 0, data.length - 1);
    }

    public static <T extends Comparable<T>> int binarySearch(T[] data, T target, int min, int max)
    {
        if(data == null)
        {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if(target == null)
        {
            throw new IllegalArgumentException("Target cannot be null");
        }

        return binarySearchChecked(data, target, min, max);
    }

    private static <T extends Comparable<T>> int binarySearchChecked(T[] data, T target, int min, int max)
    {
        int indexOfFoundItem = -1;
        int midpoint = (min + max) / 2;

        int compVal = target.compareTo(data[midpoint]);

        if(compVal == 0)
        {
            binarySearchCount++;
            indexOfFoundItem = midpoint;
        } else if(compVal > 0) {
            if(midpoint + 1 <= max)
            {
                binarySearchCount++;
                indexOfFoundItem = binarySearchChecked(data, target, midpoint + 1, max);
            }
        } else {
            if(min <= midpoint - 1)
            {
                binarySearchCount++;
                indexOfFoundItem = binarySearchChecked(data, target, min, midpoint - 1);
            }
        }

        return indexOfFoundItem;
    }

    public static class SearchResult
    {
        private int _index ;
        private int _comparisons ;
        public SearchResult( int index, int comparisons ) {
            _index       = index       ;
            _comparisons = comparisons ;
        }
        public int getIndex() { return _index ; } public int getComparisons() { return _comparisons ; }
        public void incrementComparisons() { ++_comparisons ; }
    }
}

import DSAndAlgos.SearchingEx;

public class CompareSearchStrategies
{
    public static void main(String[] args)
    {
        searchFunction(52, false);
        searchFunction(19, false);
        searchFunction(6, false);
        searchFunction(2, false);
        searchFunction(4, false);
        searchFunction(5, false);

        System.out.println(" ");

        searchFunction(52, true);
        searchFunction(19, true);
        searchFunction(6, true);
        searchFunction(2, true);
        searchFunction(4, true);
        searchFunction(5, true);
    }

    public static void searchFunction(int findIndex, boolean isLinearSearch)
    {
        int indexOfTarget = 0;
        SearchingEx.linearSearchCount = 0;
        SearchingEx.binarySearchCount = 0;

        Integer[] pool = {2, 4, 6, 7, 16, 19, 25, 30, 31, 39, 41, 52, 55, 70, 75, 80, 81, 83, 88, 90, 94, 97, 98};
        if(isLinearSearch)
        {
            indexOfTarget = SearchingEx.linearSearch(pool, findIndex);
            if(indexOfTarget != -1)
            {
                System.out.println("linearSearch found " + findIndex + " at index " + indexOfTarget + " after " + SearchingEx.linearSearchCount + " comparisons.");
            } else {
                SearchingEx.linearSearchCount--;
                System.out.println("linearSearch didn't find " + findIndex + " after " + SearchingEx.linearSearchCount + " comparisons.");
            }
        } else
        {
            indexOfTarget = SearchingEx.binarySearch(pool, findIndex);
            if(indexOfTarget != -1)
            {
                System.out.println("binarySearch found " + findIndex + " at index " + indexOfTarget + " after " + SearchingEx.binarySearchCount + " comparisons.");
            } else {
                SearchingEx.binarySearchCount++;
                System.out.println("binarySearch didn't find " + findIndex + " after " + SearchingEx.binarySearchCount + " comparisons.");
            }
        }
    }
}

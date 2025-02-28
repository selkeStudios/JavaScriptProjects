import DSAndAlgos.SortingEx;

public class CompareSortStrategies
{
    public static void main(String[] args) {
        System.out.println("Algorithm         # of Comparisons");
        System.out.println("----------------------------------");

        for(int i = 1; i <= 5; ++i)
        {
            sortFunction(i);
        }
    }

    public static void sortFunction(int sortVariation)
    {
        Integer[] pool = {6, 52, 81, 7, 31, 75, 41, 70, 90, 55, 16, 19, 83, 4, 98, 97, 94, 39, 30, 88, 25, 80, 2};

        switch(sortVariation)
        {
            case 1: //Bubble
                SortingEx.bubbleSort(pool);
                System.out.println("Bubble Sort                    " + SortingEx.bubbleSortCount);
                break;
            case 2: //Selection
                SortingEx.selectionSort(pool);
                System.out.println("Selection Sort                 " + SortingEx.selectionSortCount);
                break;
            case 3: //Insertion
                SortingEx.insertionSort(pool);
                System.out.println("Insertion Sort                 " + SortingEx.insertionSortCount);
                break;
            case 4: //Merge
                SortingEx.mergeSort(pool);
                System.out.println("Merge Sort                     " + SortingEx.mergeSortCount);
                break;
            case 5: //Quick
                SortingEx.quickSort(pool);
                System.out.println("Quick Sort                     " + SortingEx.quickSortCount);
                break;
        }
    }
}

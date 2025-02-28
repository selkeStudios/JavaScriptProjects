import DSAndAlgos.*;
import java.util.Scanner;
import java.util.Random;

public class OrderedListMerger {

    public static void main(String[] args) {
        LinkedOrderedList<String> nameListOne = new LinkedOrderedList<>();
        LinkedOrderedList<String> nameListTwo = new LinkedOrderedList<>();

        Scanner myScan = new Scanner(System.in);
        String s = " ";
        Random rand = new Random();

        do {
            System.out.print("Enter a name (leave blank to proceed to merge phase): ");
            s = myScan.nextLine();
            int randomIndexNum = rand.nextInt(2);
            if(randomIndexNum <= 0)
            {
                nameListOne.add(s);
            } else {
                nameListTwo.add(s);
            }
        } while(!s.equals(""));

        System.out.println(mergeLists(nameListOne, nameListTwo).toString());
        System.out.println("Goodbye!");
    }

    public static LinkedOrderedList<String> mergeLists(LinkedOrderedList<String> list1, LinkedOrderedList<String> list2)
    {
        if (list1.isEmpty()) {
            return list2;
        } else if (list2.isEmpty()) {
            return list1;
        }

        LinkedOrderedList<String> mergedList = new LinkedOrderedList<>();

        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.peek().compareTo(list2.peek()) < 0) {
                mergedList.add(list1.peek());
                list1.remove(list1.peek());
            } else {
                mergedList.add(list2.peek());
                list2.remove(list2.peek());
            }
        }

        while (!list1.isEmpty()) {
            mergedList.add(list1.peek());
            list1.remove(list1.peek());
        }

        while (!list2.isEmpty()) {
            mergedList.add(list2.peek());
            list2.remove(list2.peek());
        }

        return mergedList;
    }
}

import DSAndAlgos.*;
import java.util.Scanner;

public class OrganDonation {
    public static void main(String[] args)
    {
        ArrayIndexedList<String> organList = new ArrayIndexedList<>();
        ArrayIndexedList<String> patientList = new ArrayIndexedList<>();

        printOptions(organList, patientList);
    }

    public static void printOptions(ArrayIndexedList<String> o, ArrayIndexedList<String> p)
    {
        Scanner myScan = new Scanner(System.in);

        System.out.println("1.) Register organ needed.");
        System.out.println("2.) Register organ donated.");
        System.out.println("3.) Exit");
        System.out.println("----------------------------");
        System.out.print("Select 1, 2 or 3: ");
        String readEntry = myScan.nextLine();
        getNumberEntry(readEntry, o, p);
    }

    public static void getNumberEntry(String str, ArrayIndexedList<String> o, ArrayIndexedList<String> p)
    {
        try {
            entryCommands(Integer.parseInt(str), o, p);
        } catch(NumberFormatException e) {
            System.out.println(" ");
            System.out.println("Invalid selection. Please try again.");
            System.out.println(" ");
            printOptions(o, p);
        }
    }

    public static void entryCommands(int numberEntry, ArrayIndexedList<String> o, ArrayIndexedList<String> p)
    {
        Scanner myScan = new Scanner(System.in);

        switch(numberEntry)
        {
            case 1:
                System.out.println(" ");
                System.out.print("For who? ");
                String s = myScan.nextLine();
                p.add(s);
                System.out.println(" ");
                System.out.print("What organ? ");
                String t = myScan.nextLine();
                o.add(t);
                System.out.println(" ");
                printOptions(o, p);
                break;
            case 2:
                System.out.println(" ");
                System.out.print("By who? ");
                String u = myScan.nextLine();
                System.out.println(" ");
                System.out.print("What organ? ");
                String v = myScan.nextLine();
                if(o.contains(v))
                {
                    int organToPatientIndexNum = o.indexOf(v);
                    System.out.println(u + "'s " + o.get(organToPatientIndexNum) + " was given to " + p.get(organToPatientIndexNum));
                    o.remove(v);
                    p.removeAt(organToPatientIndexNum);
                }
                System.out.println(" ");
                printOptions(o, p);
                break;
            case 3:
                System.out.println(" ");
                System.out.println("Goodbye!");
                break;
            default:
                break;
        }
    }
}
import DSAndAlgos.*;

import java.util.Scanner;

public class KidneyDonation
{
    public static void main(String[] args)
    {
        ArrayQueue<String> patientsNeedingKidneys = new ArrayQueue<>();
        ArrayQueue<String> patientsDonatingKidneys = new ArrayQueue<>();

        printOptions(patientsNeedingKidneys, patientsDonatingKidneys);
    }

    public static void printOptions(ArrayQueue<String> aQN, ArrayQueue<String> aQD)
    {
        Scanner myScan = new Scanner(System.in);

        System.out.println("1.) Register kidney needed.");
        System.out.println("2.) Register kidney donated.");
        System.out.println("3.) Exit");
        System.out.println("----------------------------");
        System.out.print("Select 1, 2 or 3: ");
        String readEntry = myScan.nextLine();
        getNumberEntry(readEntry, aQN, aQD);
    }

    public static void getNumberEntry(String str, ArrayQueue<String> aQN, ArrayQueue<String> aQD)
    {
        try {
            entryCommands(Integer.parseInt(str), aQN, aQD);
        } catch(NumberFormatException e) {
            System.out.println(" ");
            System.out.println("Invalid selection. Please try again.");
            System.out.println(" ");
            printOptions(aQN, aQD);
        }
    }

    public static void entryCommands(int numberEntry, ArrayQueue<String> aQN, ArrayQueue<String> aQD)
    {
        Scanner myScan = new Scanner(System.in);

        switch(numberEntry)
        {
            case 1:
                System.out.println(" ");
                System.out.print("For who? ");
                String s = myScan.nextLine();
                aQN.enqueue(s);
                System.out.println(" ");
                printOptions(aQN, aQD);
                break;
            case 2:
                System.out.println(" ");
                System.out.print("By who? ");
                String t = myScan.nextLine();
                aQD.enqueue(t);
                System.out.println(" ");
                System.out.println(aQD.first() + "'s kidney was given to " + aQN.first());
                System.out.println(" ");
                aQN.dequeue();
                aQD.dequeue();
                printOptions(aQN, aQD);
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
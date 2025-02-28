import DSAndAlgos.LinkedQueue;

import java.util.Scanner;
import java.util.StringTokenizer;

public class RepeatingKeyCipher
{
    public static void main(String[] args)
    {
        printOptions();
    }

    public static void printOptions()
    {
        Scanner myScan = new Scanner(System.in);

        System.out.println("1.) Encode a message.");
        System.out.println("2.) Decode a message.");
        System.out.println("3.) Exit");
        System.out.println("----------------------------");
        System.out.print("Select 1, 2 or 3: ");
        String readEntry = myScan.nextLine();
        getNumberEntry(readEntry);
    }

    public static void getNumberEntry(String str)
    {
        try {
            entryCommands(Integer.parseInt(str));
        } catch(NumberFormatException e) {
            System.out.println(" ");
            System.out.println("Invalid selection. Please try again.");
            System.out.println(" ");
            printOptions();
        }
    }

    public static void entryCommands(int numberEntry)
    {
        Scanner myScan = new Scanner(System.in);
        LinkedQueue<Integer> numbers = new LinkedQueue<>();
        int keyValue = 0;

        String outputStr = " ";

        switch(numberEntry)
        {
            case 1:
                System.out.println(" ");
                System.out.print("Enter the key: ");
                String key = myScan.nextLine();
                StringTokenizer st = new StringTokenizer(key, " ");
                while(st.hasMoreTokens())
                {
                    String token = st.nextToken();

                    try
                    {
                        numbers.enqueue(Integer.parseInt(token));
                    } catch(NumberFormatException e)
                    {
                        System.out.println("Default");
                    }
                }
                System.out.println(" ");
                System.out.print("Enter the message: ");
                String message = myScan.nextLine();
                for(int i = 0; i < message.length(); ++i)
                {
                    keyValue = numbers.first();
                    numbers.enqueue(numbers.first());
                    outputStr += (char) (message.charAt(i) + keyValue);
                    numbers.dequeue();
                }
                System.out.println(" ");
                System.out.println("Encoded message:" + outputStr);
                System.out.println(" ");
                printOptions();
                break;
            case 2:
                System.out.println(" ");
                System.out.print("Enter the key: ");
                String decodeKey = myScan.nextLine();
                StringTokenizer decodeSt = new StringTokenizer(decodeKey, " ");
                while(decodeSt.hasMoreTokens())
                {
                    String token = decodeSt.nextToken();

                    try
                    {
                        numbers.enqueue(Integer.parseInt(token));
                    } catch(NumberFormatException e)
                    {
                        System.out.println("Default");
                    }
                }
                System.out.println(" ");
                System.out.print("Enter the message: ");
                String decodeMessage = myScan.nextLine();
                for(int i = 0; i < decodeMessage.length(); ++i)
                {
                    keyValue = numbers.first();
                    numbers.enqueue(numbers.first());
                    outputStr += (char) (decodeMessage.charAt(i) - keyValue);
                    numbers.dequeue();
                }
                System.out.println(" ");
                System.out.println("Decoded message:" + outputStr);
                System.out.println(" ");
                printOptions();
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
import DSAndAlgos.ArrayStack;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SentenceWordReverser
{
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        System.out.print("Enter a sentence..............................: ");
        String readSentence = myScan.nextLine();

        System.out.print("Words in the same order, with letters reversed: ");
        lettersReversedSentence(readSentence);

        System.out.print("Words reversed, with letters in the same order: ");
        wordsReversedSentence(readSentence);
    }

    private static void lettersReversedSentence(String readSent) //Get this fully functioning
    {
        ArrayStack<String> stackWithBitsOfSentence = new ArrayStack<>();

        for(int i = 0; i < readSent.length(); ++i)
        {
            if(readSent.charAt(i) != ' ')
            {
                stackWithBitsOfSentence.push(Character.toString(readSent.charAt(i)));
            } else {
                while(!stackWithBitsOfSentence.isEmpty())
                {
                    System.out.print(stackWithBitsOfSentence.pop());
                }
                System.out.print(" ");
            }
        }

        while (!stackWithBitsOfSentence.isEmpty())
        {
            System.out.print(stackWithBitsOfSentence.pop());
        }

        if(stackWithBitsOfSentence.isEmpty())
        {
            System.out.println(" ");
        }
    }

    private static void wordsReversedSentence(String readSent)
    {
        StringTokenizer st = new StringTokenizer(readSent);

        ArrayStack<String> stackWithBitsOfSentence = new ArrayStack<>();
        while (st.hasMoreTokens()) {
            stackWithBitsOfSentence.push(st.nextToken());
        }

        while(!stackWithBitsOfSentence.isEmpty())
        {
            System.out.print(stackWithBitsOfSentence.pop());
            System.out.print(' ');
        }

    }
}
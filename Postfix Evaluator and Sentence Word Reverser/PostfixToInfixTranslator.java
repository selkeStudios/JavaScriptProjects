import DSAndAlgos.LinkedStack;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PostfixToInfixTranslator {
    public static void main(String[] args) {
        LinkedStack<String> inFixTranslated = new LinkedStack<>();
        Scanner myScan = new Scanner(System.in);

        System.out.print("Enter an expression in postfix notation: ");
        String postFixToBeTranslated = myScan.nextLine();
        StringTokenizer st = new StringTokenizer(postFixToBeTranslated, " ");

        while(st.hasMoreTokens())
        {
            String num2;
            String num1;
            String token = st.nextToken();

            try{
                Integer.parseInt(token);
                inFixTranslated.push(token + "");
            } catch(NumberFormatException e) {
                switch(token)
                {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        String symbol1 = inFixTranslated.peek();
                        inFixTranslated.pop();
                        String symbol2 = inFixTranslated.peek();
                        inFixTranslated.pop();
                        inFixTranslated.push("(" + symbol2 + token + symbol1 + ")");
                        break;
                    default:
                        System.out.println("Default");
                        break;
                }
            }
        }

        System.out.print("Expressed with infix notation that is..: ");
        System.out.print(inFixTranslated.peek());
    }
}
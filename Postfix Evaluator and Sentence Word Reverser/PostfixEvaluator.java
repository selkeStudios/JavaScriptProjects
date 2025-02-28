import DSAndAlgos.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PostfixEvaluator {
    public static void main(String[] args) {
        ArrayStack<Integer> postFixStack = new ArrayStack<>();
        Scanner myScan = new Scanner(System.in);

        System.out.print("Enter an expression in postfix notation: ");
        String readPostFix = myScan.nextLine();
        StringTokenizer st = new StringTokenizer(readPostFix, " ");

        while(st.hasMoreTokens())
        {
            int num2;
            int num1;
            String token = st.nextToken();

            try {
                Integer.parseInt(token);
                postFixStack.push(Integer.parseInt(token));
            } catch(NumberFormatException e)
            {
                switch(token)
                {
                    case "+":
                        num2 = postFixStack.pop();
                        num1 = postFixStack.pop();
                        postFixStack.push(num1 + num2);
                        break;
                    case "-":
                        num2 = postFixStack.pop();
                        num1 = postFixStack.pop();
                        postFixStack.push(num1 - num2);
                        break;
                    case "*":
                        num2 = postFixStack.pop();
                        num1 = postFixStack.pop();
                        postFixStack.push(num1 * num2);
                        break;
                    case "/":
                        num2 = postFixStack.pop();
                        num1 = postFixStack.pop();
                        postFixStack.push(num1 / num2);
                        break;
                    default:
                        System.out.println("Default");
                        break;
                }
            }
        }

        System.out.print("The result of that calculation is......: ");
        System.out.println(postFixStack.pop());
    }
}

public class Recursions
{
    public static void main(String[] args)
    {
        System.out.println("Solving Towers of Hanoi with 3 discs:");
        System.out.println("-------------------------------------");
        int threeDiscMoveCount = towersOfHanoi(3, 1, 2, 3);
        System.out.println("-------------------------------------");
        System.out.println("Total Moves: " + threeDiscMoveCount);
        System.out.println(" ");
        System.out.println("Solving Towers of Hanoi with 9 discs:");
        System.out.println("-------------------------------------");
        int nineDiscMoveCount = towersOfHanoi(9, 1, 2, 3);
        System.out.println("-------------------------------------");
        System.out.println("Total Moves: " + nineDiscMoveCount);
        System.out.println(" ");
        System.out.println("The  5th Fibonacci number is " + fibonacci(5) + ".");
        System.out.println("The 12th Fibonacci number is " + + fibonacci(12) + ".");
        System.out.println("The 18th Fibonacci number is " + + fibonacci(18) + ".");
    }

    public static int towersOfHanoi(int n, int rodOne, int rodTwo, int rodThree)
    {
        int moveCount = 0;

        if (n == 1) {
            System.out.println("Move disc 1 from pole " + rodOne + " to pole " + rodTwo);
            moveCount++;
        } else {
            moveCount += towersOfHanoi(n-1, rodOne, rodThree, rodTwo);
            System.out.println("Move disc " + n + " from pole " + rodOne + " to pole " + rodTwo);
            moveCount++;
            moveCount += towersOfHanoi(n-1, rodThree, rodTwo, rodOne);
        }

        return moveCount;
    }

    public static int fibonacci(int n)
    {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
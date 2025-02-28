import DSAndAlgos.*;
import java.util.Scanner;

public class IntersectionLaneSimulator
{
    public static void main(String[] args)
    {
        Scanner myScan = new Scanner(System.in);
        String readEntry = " ";

        int simulationDuration = 0;
        int greenLightDuration = 0;
        int redLightDuration = 0;
        int arrivingCarsRate = 0;
        int passingThroughCarsRate = 0;

        int time = 0;
        boolean isLightGreen = false;
        LinkedQueue<Integer> carLane = new LinkedQueue<>();
        int carsPassed = 0;

        do{
            System.out.print("Enter the duration for the simulation.: ");
            readEntry = myScan.nextLine();
        } while(!isStringNumeric(readEntry));
        simulationDuration = Integer.parseInt(readEntry);

        do{
            System.out.print("Enter the duration of the green light.: ");
            readEntry = myScan.nextLine();
        } while(!isStringNumeric(readEntry));
        greenLightDuration = Integer.parseInt(readEntry);

        do{
            System.out.print("Enter the duration of the red light.: ");
            readEntry = myScan.nextLine();
        } while(!isStringNumeric(readEntry));
        redLightDuration = Integer.parseInt(readEntry);

        do{
            System.out.print("Enter the rate of cars arriving: ");
            readEntry = myScan.nextLine();
        } while(!isStringNumeric(readEntry));
        arrivingCarsRate = Integer.parseInt(readEntry);

        do{
            System.out.print("Enter the rate of cars passing through: ");
            readEntry = myScan.nextLine();
        } while(!isStringNumeric(readEntry));
        passingThroughCarsRate = Integer.parseInt(readEntry);

        for (int i = 0; i <= simulationDuration; i+=5) {
            String outPutStr = " ";
            if(i != 0)
            {
                outPutStr += "[ " + i + " ] ";
                if (time % redLightDuration == 0) {
                    isLightGreen = false;
                    outPutStr += "The light has turned from green to red. ";
                } else if (time % greenLightDuration == 0) {
                    isLightGreen = true;
                    outPutStr += "The light has turned from red to green. ";
                }

                if (Math.random() < arrivingCarsRate) {
                    carLane.enqueue(time);
                    outPutStr += "A car has arrived. ";
                }

                if (isLightGreen && !carLane.isEmpty() && time % greenLightDuration != 0) {
                    carLane.dequeue();
                    carsPassed++;
                    outPutStr += "A car has passed through the intersection. ";
                }

                System.out.println(outPutStr);
            }

            time += 5;
        }

        System.out.print("[Finished] ");
        System.out.println(carLane.size() + " cars are currently in the lane.");
    }

    public static boolean isStringNumeric(String entry)
    {
        try
        {
            Integer.parseInt(entry);
            return true;
        } catch(NumberFormatException e)
        {
            System.out.println("Invalid response. Please try again.");
            return false;
        }
    }
}

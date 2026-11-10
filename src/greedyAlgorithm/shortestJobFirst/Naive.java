package greedyAlgorithm.shortestJobFirst;

import java.util.Arrays;

public class Naive
{
    public static void main(String[] args)
    {
        int[] tasks = {4, 3, 1, 2, 7};

        int avgWaitingTime = findAvgWaiting(tasks);
        System.out.print(avgWaitingTime);
    }

    private static int findAvgWaiting(int[] tasks) {

        int time = 0;
        int waitingTime = 0;

        Arrays.sort(tasks);

        for(int i = 0 ; i < tasks.length ; i++)
        {
            waitingTime += time;
            time += tasks[i];
        }
        System.out.print("waiting time: " + waitingTime);
        return waitingTime / tasks.length;
    }
}

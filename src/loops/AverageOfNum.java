package loops;

import java.util.Scanner;

public class AverageOfNum
{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int testCases = sc.nextInt();
//        int sum = 0;
//
//        for(int i = 0 ; i < testCases ; i++)
//        {
//            int number = sc.nextInt();
//            sum = sum+number;
//        }
//
//        double avg = (double) sum / testCases;
//
//        System.out.println("sum : "+ sum +"\n"+ "Average : "+ avg);
//
//        sc.close();
//    }

    static int number;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            number = sc.nextInt();
        }
        avg(t,number);
    }

    static void avg(int t, int num)
    {
        int sum = 0;

        for (int i = 0; i < t; i++)
        {
            sum += num;
        }

        double avg = (double) sum/t;

        System.out.println(sum + " " + avg);
    }

}

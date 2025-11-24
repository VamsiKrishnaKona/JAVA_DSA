package patterns;

public class Patterns
{
    //* * * * *
    //* * * * *
    //* * * * *
    //* * * * *
    //* * * * *
    static void pattern1(int num)
    {
        for(int i = 1 ; i <= num ; i++)
        {
            for(int j = 1 ; j <= num ; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //*
    //* *
    //* * *
    //* * * *
    //* * * * *
    static void pattern2(int num)
    {
        for(int i = 1 ; i <= num ; i++)
        {
            for(int j = 1 ; j <= i ; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //1
    //1 2
    //1 2 3
    //1 2 3 4
    //1 2 3 4 5
    static void pattern3(int num)
    {
        for(int i = 1 ; i <= num ; i++)
        {
            for(int j = 1 ; j <= i ; j++)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //1
    //2 2
    //3 3 3
    //4 4 4 4
    //5 5 5 5 5
    static void pattern4(int num)
    {
        for(int i = 1 ; i <= num ; i++)
        {
            for(int j = 1 ; j <= i ; j++)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    //* * * * *
    //* * * *
    //* * *
    //* *
    //*
    static void pattern5(int num)
    {
        for(int i = 1 ; i <= num ; i++)
        {
            for(int j = i ; j <= num ; j++)
            {
                System.out.print("*" );
            }
            System.out.println();
        }
    }

    //1 2 3 4 5
    //1 2 3 4
    //1 2 3
    //1 2
    //1
    static void pattern6(int num)
    {
        for(int i = 1 ; i <= num ; i++)
        {
            for(int j = i ; j <= num ; j++)
            {
                System.out.print(j - i + 1 + " ");
            }
            System.out.println();
        }
    }

    //    *
    //   ***
    //  *****
    // *******
    //*********
    static void pattern7(int num)
    {
        for(int i = 0 ; i < num ; i++)
        {
            for(int j = 0 ; j < num - i - 1 ; j++)
            {
                System.out.print(" ");
            }

            for(int j = 0 ; j < 2 * i + 1 ; j++)
            {
                System.out.print("*");
            }

            for(int j = 0 ; j < num - i - 1 ; j++)
            {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void pattern8(int num)
    {
        for(int i = 0 ; i < num ; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                System.out.print(" ");
            }

            for(int j = 0 ; j < 2*num - (2*i + 1) ; j++)
            {
                System.out.print("*");
            }

            for(int j = 0 ; j < i ; j++)
            {
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    static void pattern9(int num)
    {
        for(int i = 1 ; i <= 2 * num - 1 ; i++)
        {
            int stars = i;
            if(i > num)
                stars = 2*num - i;

            for(int j = 1 ; j <= stars ; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int num = 5;

        //pattern1(num);
        //pattern2(num);
        //pattern3(num);
        //pattern4(num);
        //pattern5(num);
        //pattern6(num);
        //pattern7(num);
        //pattern8(num);
        pattern9(num);
    }
}

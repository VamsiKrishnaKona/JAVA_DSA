package greedyAlgorithm.lemonadeShop;

import java.util.HashMap;
import java.util.Map;

public class Naive
{
    public static void main(String[] args) {

        int[] money = new int[]{5, 5, 5, 10, 20};

        boolean moneySettled = settleMoney(money);
        System.out.print(moneySettled);
    }

    private static boolean settleMoney(int[] bills)
    {
        int fives = 0, tens = 0;

        for(int i = 0; i < bills.length; i++)
        {
            if(bills[i] == 5)
            {
                fives++;
            }
            else if(bills[i] == 10)
            {
                tens++;
                if(fives > 0)
                {
                    fives--;
                }
                else return false;
            }
            else
            {
                if(fives > 3)
                {
                    fives -= 3;
                }
                else if(fives > 0 && tens > 0)
                {
                    tens--;
                    fives--;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}

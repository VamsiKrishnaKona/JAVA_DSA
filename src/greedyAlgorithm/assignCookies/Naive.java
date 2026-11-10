package greedyAlgorithm.assignCookies;

import java.util.Arrays;

public class Naive
{
    public static void main(String[] args) {

        int[] greed = {1, 5, 3, 3, 4};
        int[] cookies = {4, 2, 1, 2, 1, 3};

        int maxAssigned = assignCookiesToChild(greed, cookies);
        System.out.print(maxAssigned);
    }

    private static int assignCookiesToChild(int[] greed, int[] cookies) {

        int n = greed.length;
        int m = cookies.length;

        Arrays.sort(cookies);
        Arrays.sort(greed);

        int g = 0, c = 0;

        while(g < n && c < m)
        {
            if(greed[g] <= cookies[c])
            {
                g++;
            }
            c++;
        }

        return g;
    }
}

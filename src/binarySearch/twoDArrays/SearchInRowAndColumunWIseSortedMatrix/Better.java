package binarySearch.twoDArrays.SearchInRowAndColumunWIseSortedMatrix;

import java.util.Arrays;

public class Better
{
    //T.C = O(N * log M)

    private static int binarySearch(int[] matrix, int len, int target)
    {
        int low = 0;
        int high = len - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(matrix[mid] == target)
            {
                return mid;
            }
            else if(target > matrix[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int[] findTargetInMatrix(int[][] matrix, int target)
    {
        int n = matrix.length;

        for(int i = 0 ; i < n ; i++)
        {
            int m = matrix[i].length;
            int row = i;
            int col = binarySearch(matrix[i], m, target);

            if(col != -1) return new int[]{row, col};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 4 , 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 14;

        int[] ans = findTargetInMatrix(matrix, target);

        System.out.print(Arrays.toString(ans));
    }
}

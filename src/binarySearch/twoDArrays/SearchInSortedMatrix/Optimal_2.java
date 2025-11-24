package binarySearch.twoDArrays.SearchInSortedMatrix;

import java.util.Arrays;

public class Optimal_2
{
    private static int[] findTargetInMatrix(int[][] matrix, int target)
    {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] == target) return new int[]{row, col};
            else if(matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{
                {3, 4, 7, 9},
                {12, 13, 16, 18},
                {20, 21, 23, 29}
        };

        int target = 29;

        int[] ans = findTargetInMatrix(matrix, target);

        System.out.print(Arrays.toString(ans));
    }
}

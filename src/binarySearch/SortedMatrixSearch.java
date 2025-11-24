package binarySearch;

import java.util.Arrays;

public class SortedMatrixSearch
{
    public static void main(String[] args)
    {
        int[][] arr = {
<<<<<<< HEAD
                {1, 4 , 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 14;
=======
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int target = 9;
>>>>>>> origin/krishna
        System.out.println(Arrays.toString(search(arr, target)));
    }

    static int[] binarySearch(int[][] matrix, int row, int colStart, int colEnd, int target)
    {
        while(colStart <= colEnd)
        {
            int mid = colStart + (colEnd - colStart)/2;

            if(matrix[row][mid] == target)
            {
                return new int[]{row, mid};
            }

            if(matrix[row][mid] < target)
            {
                colStart = mid + 1;
            }
            else
            {
                colEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    static int[] search(int[][] matrix, int target)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows == 1)
        {
            return binarySearch(matrix, 0, 0, cols-1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        while(rStart < (rEnd - 1))
        {
            int mid = rStart + (rEnd - rStart) / 2;

            if(matrix[mid][cMid] == target)
            {
                return new int[]{mid, cMid};
            }

            if(matrix[mid][cMid] < target)
            {
                rStart = mid;
            }
            else
            {
                rEnd = mid;
            }

        }
        if(matrix[rStart][cMid] == target)
        {
            return new int[]{rStart, cMid};
        }

        if(matrix[rStart + 1][cMid] == target)
        {
            return new int[]{rStart + 1, cMid};
        }

        //1st half
        if(target <= matrix[rStart][cMid - 1])
        {
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }

        //2nd half
        if(target <= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1])
        {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }

        //3rd half
        if(target <= matrix[rStart + 1][cMid - 1])
        {
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        } else {
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
    }


}

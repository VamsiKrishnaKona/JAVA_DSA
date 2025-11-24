package binarySearch.twoDArrays.RowWithMaxOnes;

public class BruteForce
{
    private static int findMaxRow(int[][] nums)
    {
        int n = nums.length;
        int m = nums[0].length;

        int maxRow = -1;
        int maxOnes = 0;

        for(int i = 0 ; i < n ; i++)
        {
            int count = 0;
            for(int j = 0 ; j < m ; j++)
            {
                count += nums[i][j];
            }
            if(count > maxOnes)
            {
                maxOnes = count;
                maxRow = i + 1;
            }
        }
        return maxRow;
    }


    public static void main(String[] args)
    {
        int[][] nums = new int[][]{
                {0,0,1,1,1},
                {0,0,0,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {0,1,1,1,1}
        };

        int maxRow = findMaxRow(nums);

        System.out.print(maxRow);
    }
}

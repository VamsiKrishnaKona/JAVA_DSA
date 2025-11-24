package arrays.medium.Rotate_Matrix_By_90;

public class Optimal
{
    private static void rotate(int[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0 ; i < n - 1 ; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n / 2 ; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        rotate(mat);

        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

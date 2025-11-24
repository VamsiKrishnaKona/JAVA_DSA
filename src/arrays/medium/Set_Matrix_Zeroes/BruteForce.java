package arrays.medium.Set_Matrix_Zeroes;

<<<<<<< HEAD
=======
import java.util.Arrays;

>>>>>>> origin/krishna
public class BruteForce
{
    public static void main(String[] args)
    {
        int[][] mat = new int[][]
                {
                        {1, 1, 1, 1},
                        {1, 0, 0, 1},
                        {1, 1, 0, 1},
                        {1, 1, 1, 1}
                };

        setMatrixZeroes(mat);

        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setMatrixZeroes(int[][] mat)
    {
        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                if(mat[i][j] == 0)
                {
                    setRow(mat, i);
                    setCol(mat, j);
                }
            }
        }

        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                if(mat[i][j] == -1)
                {
                    mat[i][j] = 0;
                }
            }
        }
    }

    private static void setRow(int[][] mat, int row)
    {
        for(int j = 0 ; j < mat[row].length ; j++)
        {
            if(mat[row][j] != 0)
            {
                mat[row][j] = -1;
            }
        }
    }

    private static void setCol(int[][] mat, int col)
    {
        for(int i = 0 ; i < mat.length ; i++)
        {
            if(mat[i][col] != 0)
            {
                mat[i][col] = -1;
            }
        }
    }
}

package arrays.medium.Set_Matrix_Zeroes;

import java.util.ArrayList;
import java.util.Collections;

public class Optimal
{
    private static void setMatrixZeroes(int[][] mat)
    {
        int col0 = 1;

        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                if(mat[i][j] == 0)
                {
                    mat[i][0] = 0;

                    if(j != 0)
                    {
                        mat[0][j] = 0;
                    }
                    else
                    {
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1 ; i < mat.length ; i++)
        {
            for(int j = 1 ; j < mat[i].length ; j++)
            {
                if(mat[i][0] == 0 || mat[0][j] == 0)
                {
                    mat[i][j] = 0;
                }
            }
        }

        if(mat[0][0] == 0)
        {
            for(int j = 0 ; j < mat.length ; j++)
            {
                mat[0][j] = 0;
            }
        }

        if(col0 == 0)
        {
            for(int i = 0 ; i < mat.length ; i++)
            {
                mat[i][0] = 0;
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] mat = new int[][]
                {
                        {1, 1, 1, 1},
                        {1, 0, 1, 1},
                        {1, 1, 0, 1},
                        {0, 1, 1, 1}
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
}

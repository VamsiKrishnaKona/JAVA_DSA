package arrays.medium.Set_Matrix_Zeroes;

import java.util.ArrayList;
import java.util.Collections;

public class Better
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
        ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(mat.length, 0));
        ArrayList<Integer> col = new ArrayList<>(Collections.nCopies(mat[0].length, 0));

        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                if(mat[i][j] == 0)
                {
                    row.set(i, 1);
                    col.set(j, 1);
                }
            }
        }

        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                if(row.get(i) == 1 || col.get(j) == 1)
                {
                    mat[i][j] = 0;
                }
            }
        }
    }
}

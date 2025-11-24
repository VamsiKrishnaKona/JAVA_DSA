package arrays.medium.Rotate_Matrix_By_90;

public class BruteForce
{
    private static int[][] rotate(int[][] mat)
    {

        int[][] rotated = new int[mat.length][mat[0].length];

        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                rotated[j][(mat.length - 1) - i] = mat[i][j];
            }
        }
        return rotated;
    }


    public static void main(String[] args)
    {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] rotated = rotate(mat);

        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }

//    private static ArrayList<ArrayList<Integer>> rotate(int[][] mat)
//    {
//        ArrayList<ArrayList<Integer>> rotated = new ArrayList<>();
//
//        int n = mat.length;
//        int m = mat[0].length;
//
//        for(int i = 0 ; i < n ; i++)
//        {
//            rotated.add(new ArrayList<Integer>());
//            for(int j = 0 ; j < m ; j++)
//            {
//                rotated.get(i).add(0);
//            }
//        }
//
//        for(int i = 0 ; i < n ; i++)
//        {
//            for(int j = 0 ; j < m ; j++)
//            {
//                rotated.get(j).set(n - 1 - i, mat[i][j]);
//            }
//        }
//
//        return rotated;
//    }
}

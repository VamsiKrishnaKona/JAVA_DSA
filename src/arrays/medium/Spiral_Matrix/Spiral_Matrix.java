package arrays.medium.Spiral_Matrix;

import java.util.ArrayList;

public class Spiral_Matrix
{
    private static ArrayList<Integer> printMat(int[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;

        int left = 0;
        int top = 0;

        int right = m - 1;
        int bottom = n - 1;

        ArrayList<Integer> ans = new ArrayList<>();

        while(left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                ans.add(mat[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans.add(mat[i][right]);
            }
            right--;

            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(mat[bottom][i]);
                }
                bottom--;
            }

            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[][]  mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        ArrayList<Integer> ans = printMat(mat);

        System.out.println(ans);
    }
}

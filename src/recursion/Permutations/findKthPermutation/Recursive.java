package recursion.Permutations.findKthPermutation;

import java.util.ArrayList;
import java.util.List;

public class Recursive
{
    public static void main(String[] args)
    {
        int n = 3;
        int k = 3;

        findKthPermutation(n, k);
    }

    private static void findKthPermutation(int n, int k)
    {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++)
        {
            nums.add(i);
        }

        String perm = generateKthPermutation(nums, "", n, k - 1);
        System.out.print(perm);
    }

    private static String generateKthPermutation(List<Integer> nums, String permutation, int n, int k)
    {
        if(nums.size() == 1)
        {
            return permutation += nums.get(0);
        }

        int div = fact(nums.size() - 1);
        int reqIdx = k / div;

        permutation += nums.get(reqIdx);

        int newKth = k % div;

        nums.remove(reqIdx);

        return generateKthPermutation(nums, permutation, n, newKth);
    }

    private static int fact(int n)
    {
        int ans = 1;
        while(n > 1)
        {
            ans = ans * n;
            n--;
        }

        return ans;
    }
}

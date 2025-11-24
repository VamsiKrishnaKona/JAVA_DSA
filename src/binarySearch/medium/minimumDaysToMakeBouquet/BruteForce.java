package binarySearch.medium.minimumDaysToMakeBouquet;

public class BruteForce
{
    static boolean func(int[] daysToBloom, int noOfBoquets, int noOfFlowerToUse, int day) {
        int boquetDone = 0;
        int bloomCount = 0;
        for (int i = 0; i < daysToBloom.length; i++) {
            if (daysToBloom[i] <= day) {
                bloomCount += 1;
            } else {
                boquetDone += (bloomCount / noOfFlowerToUse);
                bloomCount = 0;
            }
        }
        boquetDone += (bloomCount / noOfFlowerToUse);

        if (boquetDone >= noOfBoquets) return true;

        return false;
    }

    static int minNoOfDaysToMakeBoquets(int[] daysToBloom, int noOfBoquets, int noOfFlowerToUse) {
        int maxDays = maxx(daysToBloom);
        int minDays = minn(daysToBloom);

        for (int day = minDays; day <= maxDays; day++) {
            if (func(daysToBloom, noOfBoquets, noOfFlowerToUse, day)) {
                return day;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] daysToBloom = {7, 7, 7, 7, 13, 11, 12, 7};
        int noOfBoquets = 2;
        int noOfFlowerToUse = 3;

        int ans = minNoOfDaysToMakeBoquets(daysToBloom, noOfBoquets, noOfFlowerToUse);

        System.out.print(ans);
    }

    static int maxx(int[] pile) {
        int max = -1;
        for (int i = 0; i < pile.length; i++) {
            if (pile[i] > max) max = pile[i];
        }
        return max;
    }

    static int minn(int[] pile) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < pile.length; i++) {
            if (pile[i] < min) min = pile[i];
        }
        return min;
    }

}

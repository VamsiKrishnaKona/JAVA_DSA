package hashing;

import java.util.HashMap;

public class FraudDetection
{
    public static void hasDuplicateTransactions(int[] transactions)
    {
        HashMap<Integer, Integer> tnx = new HashMap<>();

        for(int i = 0 ; i < transactions.length ; i++)
        {
            tnx.put(transactions[i], tnx.getOrDefault(transactions[i], 0) + 1);
        }

        for (HashMap.Entry<Integer, Integer> e : tnx.entrySet()) {
            System.out.println(e.getKey() +" : " + e.getValue());
        }
    }

    public static void main(String[] args) {
        int[] transactions = {101, 205, 301, 405, 101,307};

        hasDuplicateTransactions(transactions);
    }
}

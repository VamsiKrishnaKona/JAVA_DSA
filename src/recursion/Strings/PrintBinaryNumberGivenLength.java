package recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryNumberGivenLength
{
    public static void print(int n, String binary, List<String> binaries)
    {
        if(binary.length() == n)
        {
            binaries.add(binary);
            return;
        }

        print(n, binary + '0', binaries);

        if(binary.isEmpty() || binary.charAt(binary.length() - 1) != '1')
        {
            print(n, binary + '1', binaries);
        }
    }

    public static void printBinaries(int n)
    {
        String s = "";
        List<String> strings = new ArrayList<>();

        print(n, s, strings);

        System.out.println(strings);
    }

    public static void main(String[] args)
    {
        int n = 3;

        printBinaries(n);
    }
}

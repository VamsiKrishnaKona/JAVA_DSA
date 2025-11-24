package UST;

public class FindBreachWordCount
{
    public static int findBreachCount(String logs)
    {
        String[] logEntries = logs.split(";");

        int breachCount = 0;

        for(String entry : logEntries)
        {
            if(entry.toLowerCase().contains("breach"))
            {
                breachCount++;
            }
        }
        return breachCount; 
    }


    public static void main(String[] args) {
        // Test case 1: basic test
        String logs1 = "Unauthorized access detected;System Breach occurred;User login successful";
        System.out.println("Test Case 1: " + findBreachCount(logs1)); // Output: 1

        // Test case 2: multiple breaches
        String logs2 = "Data Breach detected;Security BREACH reported;breach in protocol;";
        System.out.println("Test Case 2: " + findBreachCount(logs2)); // Output: 3

        // Test case 3: no breaches
        String logs3 = "All systems functional;Routine maintenance completed;";
        System.out.println("Test Case 3: " + findBreachCount(logs3)); // Output: 0

        // Test case 4: mixed case and noise
        String logs4 = "BrEach was found;system restart;No BrEaCH Here;";
        System.out.println("Test Case 4: " + findBreachCount(logs4)); // Output: 2
    }
}

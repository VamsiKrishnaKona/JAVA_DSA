package UST.staticExample;

public class Database
{
    static String url = "";

    static {
        System.out.println("Connecting to database...");
        url = "jdbc:mysql://localhost:3306/";
    }
}

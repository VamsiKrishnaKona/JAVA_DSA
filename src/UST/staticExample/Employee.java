package UST.staticExample;

public class Employee
{
    int id;
    String name;

     int empId = 0;
    static String company = "UST";

    public Employee(int id, String name)
    {
        this.id = id;
        this.name = name;
        empId++;
        System.out.println("Employee created");
        //System.out.println("Employee ID: " + empId);
    }

    public void printName()
    {
        System.out.println(this.name);
    }

    public static void printNameStatic(Employee employee)
    {
        System.out.println(employee.name);
    }
}

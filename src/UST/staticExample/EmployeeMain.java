package UST.staticExample;

public class EmployeeMain
{
    public static void main(String[] args) {

        Employee emp1 = new Employee(1, "Krishna");
        Employee emp2 = new Employee(2, "Sathvik");

//        System.out.println(emp1.id);
//        System.out.println(emp1.name);
//        System.out.println(Employee.company);

//        emp1.printName();
//        Employee.printNameStatic(emp1);

        System.out.println(emp1.empId);
        System.out.println(emp2.empId);
    }
}

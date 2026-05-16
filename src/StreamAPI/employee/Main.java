package StreamAPI.employee;

import org.w3c.dom.ls.LSOutput;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<Employee> employees = List.of(
                new Employee(1, "Krishna", "IT", 75000, 25, "Male"),
                new Employee(2, "Anjali", "HR", 50000, 30, "Female"),
                new Employee(3, "Ravi", "Finance", 65000, 28, "Male"),
                new Employee(4, "Sneha", "IT", 80000, 26, "Female"),
                new Employee(5, "Arjun", "IT", 90000, 32, "Male"),
                new Employee(6, "Meena", "HR", 55000, 27, "Female"),
                new Employee(7, "Kiran", "Finance", 70000, 29, "Male"),
                new Employee(8, "Divya", "IT", 72000, 24, "Female"),
                new Employee(9, "Rahul", "HR", 48000, 31, "Male"),
                new Employee(10, "Pooja", "Finance", 68000, 26, "Female")
        );

        //employeesFromIT(employees);
        //getNamesOfEmployees(employees);
        //getEmployeesWithSalaryAbove70K(employees);
        //getEmployeesCount(employees);
        //getFemaleEmployees(employees);
        //getALlEmployeeAges(employees);
        //getEmployeesNameStartsWithGivenChar(employees);
        //convertEmployeeNamesToUpperCase(employees);
        //getDistinctDepartments( employees);
        //checkIfAnyEmployeeEarnMoreThan100k( employees);


        //sortEmployeesBySalary(employees);
        //sortEmployeesByAgeDesc(employees);
        //findEmployeeWithHighestSalary(employees);
        //findEmployeeWithLowestSalary(employees);
        //calculateAverageOfSalary(employees);
        groupEmployeesByDept(employees);

    }

    private static void employeesFromIT(List<Employee> employees)
    {
        //Get All employees belongs to IT department
        var dummy = employees.stream().filter(emp -> emp.department.equals("IT")).toList();
        for(Employee emp : dummy) System.out.println(emp.toString());
    }

    private static void getNamesOfEmployees(List<Employee> employees)
    {
        //printing directly using foreach
        employees.stream().map(emp ->emp.getName()).forEach(name -> System.out.println(name));

        //storing data to new list
        var dum = employees.stream().map(emp -> emp.getName()).toList();
        System.out.println(dum);
    }

    private static void getEmployeesWithSalaryAbove70K(List<Employee> employees)
    {
        employees.stream().filter(employee -> employee.salary > 70000).forEach(emp -> System.out.println(emp.toString()));
    }

    private static void getEmployeesCount(List<Employee> employees)
    {
        int count = (int) employees.stream().count();
        System.out.println(count);
    }

    private static void getFemaleEmployees(List<Employee> employees)
    {
        employees.stream().filter(emp -> emp.gender.equals("Female")).forEach(emp -> System.out.println(emp));
    }

    private static void getALlEmployeeAges(List<Employee> employees)
    {
        employees.stream().map(emp -> emp.getAge()).forEach(age -> System.out.println(age));
    }

    private static void getEmployeesNameStartsWithGivenChar(List<Employee> employees)
    {
        employees.stream().filter(emp -> emp.name.startsWith("A")).forEach(emp -> System.out.println(emp));
    }

    private static void convertEmployeeNamesToUpperCase(List<Employee> employees)
    {
        employees.stream().map(emp -> emp.getName()).forEach(name -> System.out.println(name.toUpperCase()));
    }

    private static void getDistinctDepartments(List<Employee> employees)
    {
        //Collecting data to HashSet.
        //employees.stream().map(emp -> emp.getDepartment()).collect(Collectors.toSet()).forEach(dept -> System.out.println(dept));

        //Using in-built distinct method in streams
        employees.stream().map(emp -> emp.getDepartment()).distinct().forEach(System.out::println);
    }

    private static void checkIfAnyEmployeeEarnMoreThan100k(List<Employee> employees)
    {
        boolean exists = employees.stream().anyMatch(emp -> emp.getSalary() > 100000);
        System.out.println(exists);

        //employees.stream().filter(emp -> emp.getSalary() > 100000).findAny().isPresent();
    }


    // Intermediate Questions

    private static void sortEmployeesBySalary(List<Employee> employees)
    {
        //using Lambda comparator
        //employees.stream().sorted((n1, n2) -> Double.compare(n2.salary, n1.salary)).forEach(System.out::println);

        //Using Comparator.comparing
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(emp -> System.out.println(emp));
    }

    private static void sortEmployeesByAgeDesc(List<Employee> employees)
    {
        employees.stream().sorted((n1, n2) -> Integer.compare(n2.age, n1.age)).forEach(System.out::println);
    }

    private static void findEmployeeWithHighestSalary(List<Employee> employees)
    {
        //sorting By salary and using limit
        //employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(1).forEach(System.out::println);

        //Using max() and Optional to collect
        Optional<Employee> highestPaid = employees.stream().max(Comparator.comparing(Employee::getSalary));
        highestPaid.ifPresent(System.out::println);


    }

    private static void findEmployeeWithLowestSalary(List<Employee> employees)
    {
        Optional<Employee> emp = employees.stream().min(Comparator.comparing(Employee::getSalary));
        emp.ifPresent(System.out::println);
    }

    private static void calculateAverageOfSalary(List<Employee> employees)
    {
        //using average
        double average = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        System.out.println(average);

        //using Collectors.averagingDouble
        double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);
    }

    private static void groupEmployeesByDept(List<Employee> employees)
    {
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((dept, emps) -> System.out.println(emps));
    }
}

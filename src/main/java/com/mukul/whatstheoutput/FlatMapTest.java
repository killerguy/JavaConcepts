package com.mukul.whatstheoutput;

import com.mukul.java8features.lambdas.domain.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {
    public static void main(String[] args) {
        List<List<Employee>> aList = fetchEmployeeList();

        List<Employee> collect = aList.stream().flatMap(List::stream).collect(Collectors.toList());
       System.out.println("List of Employee Ids");
        collect.forEach(e -> System.out.print(e.getId()+" "));

        System.out.println("\n-----------------------CRIME--------------------------");
        aList.stream().flatMap(l -> l.stream().filter(e -> e.getDepartment().equals("Crime"))).forEach(employee -> System.out.println(employee.getName()));

       System.out.println("-----------------------Starts With O--------------------------");
       aList.stream().flatMap(l -> l.stream().filter(e -> e.getName().startsWith("O")))
               .forEach(employee -> System.out.println(employee.getName()+" - "+employee.getDepartment() ));
    }

    private static List<List<Employee>> fetchEmployeeList() {
        List<List<Employee>> empList = new ArrayList<>();
        Employee emp1 = new Employee(1, "Redington", "Crime");
        Employee emp2 = new Employee(2, "Oliver", "Crime");
        Employee emp3 = new Employee(3, "Sheldon", "Physics");
        Employee emp4 = new Employee(4, "Olivia", "FBI");
        Employee emp5 = new Employee(5, "Elliot", "Cyber-Criminal");

        List<Employee> l1 = Arrays.asList(emp1, emp2, emp3);
        List<Employee> l2 = Arrays.asList(emp4, emp5);
        empList.add(l1);
        empList.add(l2);
        return empList;
    }
}

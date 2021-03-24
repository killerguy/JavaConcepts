package com.mukul.java8features.lambdas.streamoperations;

import com.mukul.java8features.lambdas.domain.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCollectorsExample {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(100, "emp1", "Accounts"));
        employees.add(new Employee(200, "emp2", "Accounts"));
        employees.add(new Employee(300, "emp3", "Accounts"));
        employees.add(new Employee(400, "emp4", "Accounts"));

        HashMap hashMap = getEmployeeInfo(employees);

        System.out.println(hashMap);

    }


    private static HashMap<Integer, Employee> getEmployeeInfo(List<Employee> products) {
        return products.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Function.identity(),
                        (a, b) -> a,
                        HashMap::new
                ));
    }

}

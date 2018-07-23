package com.mukul.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;

public class JSONToJavaExample {
    public static void main(String[] args) {
        loadAndPrintJSONValues();
    }

    private static void loadAndPrintJSONValues() {
        Employees employee = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            employee = mapper.readValue(new File("jsonOutput.txt"), Employees.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(employee);
    }
}

class Employee {

    private int empId = 1015;
    private String name = "Mukul";
    private String designation = "Sr. Developer";
    private String department = "Consulting";
    private int salary = 20000;


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", department="
                + department + ", salary=" + salary + "]";
    }


}

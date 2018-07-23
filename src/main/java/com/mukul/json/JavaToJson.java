package com.mukul.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JavaToJson {
    public static void main(String[] args) {

        Employees employee = new Employees(1, "Mukul", "Chaudhari");
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("jsonOutput.txt"), employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Employees {
    private Integer id;
    private String firstName;
    private String lastName;

    public Employees() {

    }

    public Employees(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employees [id=" + id + ", firstName=" + firstName + ", " +
                "lastName=" + lastName + "]";
    }
}


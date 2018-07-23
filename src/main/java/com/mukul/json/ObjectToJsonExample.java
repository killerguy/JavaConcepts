package com.mukul.json;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
 
public class ObjectToJsonExample {
 
    public static void main(String[] a){
         
        Employee emp = new Employee();
        ObjectMapper mapperObj = new ObjectMapper();
         
        try {
            // get Employee object as a json string
            String jsonStr = mapperObj.writeValueAsString(emp);
            System.out.println(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

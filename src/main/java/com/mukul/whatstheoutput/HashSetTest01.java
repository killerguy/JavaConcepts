package com.mukul.whatstheoutput;

import java.util.HashSet;

public class HashSetTest01 {
    public static void main(String[] args) {

        Customer c1= new Customer("John",20);
        Customer c2= new Customer("John",20);

        HashSet<Customer> customerSet=new HashSet<>();
        customerSet.add(c1);
        customerSet.add(c2);
        System.out.println(customerSet.size());
        //Output will be 2 as we did not implement hashcode and equals method in Customer class.
    }


}

class Customer {

    String name;
    int age;

    Customer(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

}

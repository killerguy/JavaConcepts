package com.mukul.java8features.common;

interface Fly {

    default void takeOff() {
        System.out.println("Fly :: takeOff");
    }

    default void turn() {
        System.out.println("Fly :: turn");
    }

    default void cruise() {
        System.out.println("Fly :: cruise");
    }

    default void land() {
        System.out.println("Fly :: land");
    }

}

interface FastFly extends Fly {

    @Override
    default void takeOff() {
        System.out.println("FastFly :: takeOff");
    }
}

class Vehicle {

    public void land() {
        System.out.println("Vehicle :: land");
    }
}

interface Sail {
    default void cruise() {
        System.out.println("Sail :: cruise");
    }
}

class SeaPlane extends Vehicle implements FastFly, Sail {

    /*
        if Collision between methods of interfaces user super,
        like super here implemented in Sail as well as Fly
        Super informs that method is default
     */
    public void cruise() {
        FastFly.super.cruise();
    }


}

public class DefaultMethods {

    public static void use() {
        SeaPlane seaPlane = new SeaPlane();

        //Calls the method in FastFly since it's the nearest implementation
        seaPlane.takeOff();

        //Calls the one in Fly
        seaPlane.turn();

        //will call the one in Vehicle, since Class hierarchy rules
        seaPlane.land();

        /*
        if Collision between methods of interfaces user super
         */

    }

    public static void main(String[] args) {
        use();
    }
}
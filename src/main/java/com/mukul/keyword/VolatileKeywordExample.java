package com.mukul.keyword;

public class VolatileKeywordExample {
    private static volatile boolean sayHello = false;
    private static boolean sayHi = false;

    public static void main(String[] args) throws InterruptedException {

        withVolatile();
        //  withoutVolatile();
    }

    private static void withVolatile() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!sayHello) {
            }
            System.out.println("Hello World!");
            while (sayHello) {
            }
            System.out.println("Good Bye!");
        });

        thread.start();

        Thread.sleep(1000);
        System.out.println("Say Hello..");
        sayHello = true;

        Thread.sleep(1000);
        System.out.println("Say Bye..");
        sayHello = false;
    }


    public static void withoutVolatile() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!sayHi) {
            }

            System.out.println("Hello World!");
            while (sayHi) {
            }

            System.out.println("Good Bye!");
        });

        thread.start();

        Thread.sleep(100);
        System.out.println("Say Hello..");
        sayHi = true;

        Thread.sleep(1000);
        System.out.println("Say Bye..");
        sayHi = false;

        thread.stop();
    }
}

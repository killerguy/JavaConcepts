package com.mukul.java7features;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyAutoClosable implements AutoCloseable {

    public void doIt() {
        System.out.println("MyAutoClosable doing it!");
    }

    @Override
    public void close() {
        System.out.println("MyAutoClosable closed!");
    }

    private static void myAutoClosable() throws Exception {

        try (MyAutoClosable myAutoClosable = new MyAutoClosable()) {
            myAutoClosable.doIt();
        }
    }

    public static void main(String[] args) throws Exception {
        myAutoClosable();
        log.info("Main method closed");
    }

}



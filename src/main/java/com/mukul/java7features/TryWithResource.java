package com.mukul.java7features;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TryWithResource {

    private static void printFileJava7() throws IOException {

        try (FileInputStream input = new FileInputStream("C:\\jsonOutput.txt");
             BufferedInputStream bufferedInput = new BufferedInputStream(input)
        ) {

            int data = bufferedInput.read();
            while (data != -1) {
                System.out.print((char) data);
                data = bufferedInput.read();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        printFileJava7();
    }
}

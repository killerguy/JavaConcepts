package com.mukul.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesExample {
    private static final String PROPERTY_FILE_NAME = "/sample.properties";

    public static void main(String a[]) {

        PropertiesExample myProp = new PropertiesExample();
        myProp.printAllKeys(myProp.MyPropWithinClasspath(PROPERTY_FILE_NAME));
    }

    private void printAllKeys(Properties prop) {
        Set<Object> keys = prop.keySet();
        System.out.println("***Printing all keys: ");
        for (Object obj : keys) {
            String key = (String) obj;
            System.out.println(key + ": " + prop.getProperty(key));
        }

    }

    private Properties MyPropWithinClasspath(String fileName) {
        Properties prop =  new Properties();
        try (InputStream is = this.getClass().getResourceAsStream(fileName)) {
            prop.load(is);
            System.out.println("Name: " + prop.getProperty("name"));
            System.out.println("Skills: " + prop.getProperty("skills"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


}

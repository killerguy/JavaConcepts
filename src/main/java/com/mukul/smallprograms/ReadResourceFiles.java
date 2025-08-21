package com.mukul.smallprograms;

import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReadResourceFiles {

    public String loadJsonFromResource(String filename) throws IOException {
        // Load the file from the resources folder
        File file = ResourceUtils.getFile("classpath:" + filename);

        // Read the file content as a String
        String content = new String(Files.readAllBytes(file.toPath()));

        return content;
    }

    public static void main(String[] args) throws IOException {
        ReadResourceFiles readResourceFiles = new ReadResourceFiles();
        readResourceFiles.loadJsonFromResource("JsonToPojo.json");
    }
}
package com.mukul.whatstheoutput;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class ImageConverter {

    public static void main(String[] args) throws DocumentException, IOException {
        String filename ="input";
        generatePDFFromImage(filename,"png");
    }
    private static void generatePDFFromImage(String filename, String extension) throws IOException, DocumentException {
        Document document = new Document();
        String input = filename + "." + extension;
        String output = "./" + extension + ".pdf";
        FileOutputStream fos = new FileOutputStream(output);

        PdfWriter writer = PdfWriter.getInstance(document, fos);
        writer.open();
        document.open();
        document.add(Image.getInstance((new URL(input))));
        document.close();
        writer.close();
    }

/*    public static void main(String[] args) {
        String inputFilePath = "D:/MUKUL/Workspaces/JavaConcepts/src/main/resource/input.png"; // Change to your input file path

        String outputFilePath = "/output.tiff"; // Change to your desired output file path

        try {
            InputStream inputStream = ImageConverter.class.getClassLoader().getResourceAsStream("input.png");

            BufferedImage image = ImageIO.read(inputStream);

            // Get a TIFF writer
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("TIFF");
            if (!writers.hasNext()) {
                throw new IllegalStateException("No writers found for TIFF format");
            }
            ImageWriter writer = writers.next();

            // Set up the output file
            File outputFile = new File(outputFilePath);
            ImageOutputStream ios = ImageIO.createImageOutputStream(outputFile);
            writer.setOutput(ios);

            // Set the write parameters (optional)
            ImageWriteParam param = writer.getDefaultWriteParam();
            // You can set additional parameters here if needed

            // Write the image
            writer.write(null, new javax.imageio.IIOImage(image, null, null), param);

            // Clean up
            ios.close();
            writer.dispose();

            System.out.println("Image converted successfully to TIFF format.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
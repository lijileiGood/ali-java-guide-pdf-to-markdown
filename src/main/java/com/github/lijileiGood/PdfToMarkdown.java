package com.github.lijileiGood;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PdfToMarkdown {

    public static void main(String[] args) {
        try {
            // Load the PDF document
            PDDocument document = PDDocument.load(new File("./Java开发手册(黄山版).pdf"));

            // Create a PDFTextStripper object to extract the text
            PDFTextStripper pdfStripper = new PDFTextStripper();

            // Extract the text from the PDF
            String text = pdfStripper
                    .getText(document)
                    .replace("Java 开发手册（黄山版）", "")
                    .replace("说明：", "   说明：")
                    .replace("反例：", "   反例：")
                    .replace("正例：", "   正例：")
                    ;

            System.out.println(text);

            // Close the PDF
            document.close();

            // Write the text to a Markdown file
            try (FileWriter writer = new FileWriter("./demo.md")) {
                writer.write(text);
            }

            System.out.println("Markdown file has been created!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


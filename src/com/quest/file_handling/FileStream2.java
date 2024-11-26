package com.quest.file_handling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream2 {
    public static void main(String[] args) {
        String sentences = "This is sentence 1.\n" +
                "This is sentence 2.\n" +
                "This is sentence 3.\n" +
                "This is sentence 4.\n" +
                "This is sentence 5.\n" +
                "This is sentence 6.\n" +
                "This is sentence 7.\n" +
                "This is sentence 8\n" +
                "This is sentence 9\n" +
                "This is sentence 10";
        try {
            FileOutputStream fos = new FileOutputStream("file3.txt");
            fos.write(sentences.getBytes());
            fos.close();

            FileInputStream fis = new FileInputStream("file3.txt");
            int c;
            while ((c = fis.read()) != -1) {
                System.out.print((char) c);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

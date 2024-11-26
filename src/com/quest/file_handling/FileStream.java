package com.quest.file_handling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {
    public static void main(String[] args) {
        try {
            FileInputStream f1 = new FileInputStream("file1.txt");
            System.out.println("--file created");
            int c;
            String str = "Input as streams.";
            FileOutputStream fos = new FileOutputStream("file1.txt");
            /*while ((c = f1.read()) != -1) {
                System.out.print((char) c);
            }*/
            fos.write(str.getBytes());
            while ((c = f1.read()) != -1) {
                System.out.print((char) c);
            }

            fos.close();
            f1.close();
            System.out.println("\n--file closed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

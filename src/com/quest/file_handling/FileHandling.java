package com.quest.file_handling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) throws IOException {
        File file1 = new File("file1.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        }
        try {
            Scanner sc = new Scanner(file1);
            while (sc.hasNextLine()) {
                String line1 = sc.nextLine();
                System.out.println(line1);
            }
            sc.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }/*
        finally {
            file1.delete();
        }*/
        //file1.delete();


        /*try {
            if (file1.createNewFile()) {
                System.out.println("File exist " + file1.getAbsolutePath());
            } else if (file1.exists()) {
                System.out.println("File1 exist "+file1.getAbsoluteFile());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


    }
}

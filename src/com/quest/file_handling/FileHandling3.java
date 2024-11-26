package com.quest.file_handling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling3 {
    public static void main(String[] args) {
        File file3 = new File("file3.txt");
        try {
            if (!file3.exists()) {
                file3.createNewFile();
                System.out.println("--file created");
            }

            FileWriter fw = new FileWriter(file3);
            fw.write("Hello, this is test file 3.");
            fw.append("Added more data to it");
            System.out.println("--file written");
            fw.close();

            Scanner sc = new Scanner(file3);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            file3.delete();
            System.out.println("--file deleted");
        }
    }
}

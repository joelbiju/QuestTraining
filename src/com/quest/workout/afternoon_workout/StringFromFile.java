package com.quest.workout.afternoon_workout;

import java.io.File;
import java.util.Scanner;

public class StringFromFile {
    public static void main(String[] args) {
        File file = new File("testFile.txt");

        try {
            if (!file.exists()) {
                System.out.println("File doesn't exists");
            }
            boolean found = false;
            String searchString = "batman";
            int lineNumber = 0;

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNumber++;
                if (line.contains(searchString)) {
                    System.out.println("Found in the line " + lineNumber);
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Word not found");
            }
            scanner.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

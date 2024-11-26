package com.quest.file_handling;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandling2 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("FileWriter.txt");
            fw.write("Hello World file writer example file created with text.");    //writing a string to file
            fw.append("Appended a new line into it.",0,8);              //index to values of csq to append
            fw.append('#');                                                           //appending a single character to end
            fw.append("NEW LINE");                                                   //appending a string at end
            fw.close();
            System.out.println("File created and written.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

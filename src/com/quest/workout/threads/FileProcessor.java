package com.quest.workout.threads;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileProcessor implements Runnable {
    private String fileName;

    public FileProcessor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
            int byteData;
            while ((byteData = bis.read()) != -1) {
                System.out.print((char) byteData);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}

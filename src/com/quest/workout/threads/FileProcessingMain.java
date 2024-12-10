package com.quest.workout.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileProcessingMain {
    public static void main(String[] args) {
        List<String> filenames = new ArrayList<>(Arrays.asList("file1.txt", "file2.txt", "file3.txt"));

        for (String filename : filenames) {
            Thread thread = new Thread(new FileProcessor(filename));
            thread.start();
        }

    }
}

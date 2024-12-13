package com.quest.case_study.parallel_file_reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        HashMap<String, Integer> wordFrequencies = new HashMap<>();
        try{
            FileInputStream fis = new FileInputStream("file1.txt");
            FileInputStream fis2 = new FileInputStream("file2.txt");
            Scanner sc1 = new Scanner(fis);
            Scanner sc2 = new Scanner(fis2);

            Runnable fileReader1 = () -> {
                synchronized (wordFrequencies) {
                    while (sc1.hasNextLine()) {
                        String word = sc1.nextLine();
                        if (!wordFrequencies.containsKey(word)) {
                            wordFrequencies.put(word, 1);
                        } else {
                            wordFrequencies.put(word, wordFrequencies.get(word) + 1);
                        }
                    }
                }
            };
            Runnable fileReader2 = () -> {
                synchronized (wordFrequencies) {
                    while (sc2.hasNextLine()) {
                        String word = sc2.nextLine();
                        if (!wordFrequencies.containsKey(word)) {
                            wordFrequencies.put(word, 1);
                        } else {
                            wordFrequencies.put(word, wordFrequencies.get(word) + 1);
                        }
                    }
                }
            };

            Thread thread1 = new Thread(fileReader1);
            Thread thread2 = new Thread(fileReader2);

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(wordFrequencies.entrySet().stream().
                    sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue())).
                    limit(3).toList());

            fis.close();
            fis2.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

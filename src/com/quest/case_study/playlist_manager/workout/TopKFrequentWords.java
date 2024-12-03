package com.quest.case_study.playlist_manager.workout;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("banana");
        words.add("banana");
        words.add("apple");
        words.add("banana");

        int k=2;

        List<String> topKWords = findTopKFrequent(words,k);
        System.out.println(topKWords);
    }

    public static List<String> findTopKFrequent(List<String> words, int k) {
        Map<String,Integer> frequencyMap = new HashMap<>();

        //counting frequency of each word
        for (String word : words) {
            if (frequencyMap.containsKey(word)) {
                frequencyMap.put(word, frequencyMap.get(word) + 1);
            } else {
                frequencyMap.put(word, 1);
            }
        }
        //sorting based on frequency
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a,b)->{
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            if (entry.getValue() >= k) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}

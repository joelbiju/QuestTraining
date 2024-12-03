package com.quest.case_study.playlist_manager.workout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyGrouper {
    public static void main (String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);

        Map<Integer, List<Integer>> results = groupByFrequency(numbers);

        System.out.println(results);
    }

    public static Map<Integer, List<Integer>> groupByFrequency (List<Integer> numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer number : numbers) {
            if (frequencyMap.containsKey(number)) {
                frequencyMap.put(number, frequencyMap.get(number) + 1);
            } else {
                frequencyMap.put(number, 1);
            }
        }

        Map<Integer, List<Integer>> groupedFrequency = new HashMap<>();

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            groupedFrequency.put(value, new ArrayList<>());
            groupedFrequency.get(value).add(key);
        }
        return groupedFrequency;
    }
}

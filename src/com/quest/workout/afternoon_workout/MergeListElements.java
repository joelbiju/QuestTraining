package com.quest.workout.afternoon_workout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeListElements {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("apple","orange","grape"));
        List<String> list2 = new ArrayList<>(Arrays.asList("lion","tiger","giraffe"));

        mergedList(list1, list2);

    }

    private static void mergedList(List<String> list1, List<String> list2) {
        List<String> list3 = new ArrayList<>();
        list3.addAll(list1);
        for (String s: list2){
            if (!list3.contains(s)){
                list3.add(s);
            }
        }
        System.out.println(list3);
    }
}

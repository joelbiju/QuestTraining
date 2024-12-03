package com.quest.collections.exercise.map_compare;

import java.util.Comparator;
import java.util.Map;

public class GradeComparator implements Comparator<Map.Entry<Student, Integer>> {

    @Override
    public int compare(Map.Entry<Student, Integer> o1, Map.Entry<Student, Integer> o2) {
        Integer s1Marks = o1.getValue();
        Integer s2Marks = o2.getValue();
        if (s1Marks > s2Marks){
            return 1;
        } else if (s1Marks < s2Marks){
            return -1;
        } else {
            return 0;
        }
    }
}

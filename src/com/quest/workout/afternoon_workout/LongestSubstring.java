package com.quest.workout.afternoon_workout;

import java.util.Arrays;

public class LongestSubstring {
    public static void main(String[] args){
        String[] stringArray = {"string", "programming", "array", "list"};
        int stringLength = stringArray.length;
        int[] countArray = new int[stringLength];

        int max=0;
        String maxString = "";
        for (int i = 0; i < stringLength; i++) {
            countArray[i] = stringArray[i].length();
            if (stringArray[i].length() > max) {
                max = stringArray[i].length();
                maxString = stringArray[i];
            }
        }
        System.out.println(Arrays.toString(countArray));
        System.out.println("Longest substring: "+maxString);

    }
}

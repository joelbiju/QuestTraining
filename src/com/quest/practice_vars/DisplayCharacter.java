package com.quest.practice_vars;

public class DisplayCharacter {
    public static void main(String[] args) {
        String s = "program";
        int[] count = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count[i]++;
                }
            }
        }

        boolean[] printed = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!printed[i]) {
                System.out.print(s.charAt(i) + " : " + count[i]);
                System.out.println();
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    printed[j] = true;
                }
            }
        }
    }
}

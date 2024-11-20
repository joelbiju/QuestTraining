package com.quest.workout;

public class PairCount {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 10, 10, 30, 20, 50, 40, 40, 30, 30, 10};
        boolean[] visited = new boolean[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                int count = 1;
                visited[i] = true;
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[j] == numbers[i] && !visited[j]) {
                        count++;
                        visited[j] = true;
                    }
                }
                if (count > 1) {
                    System.out.println(numbers[i] + "'s - " + (count / 2));
                }
            }
        }

//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i]!=-1){
//                int count =1;
//                for (int j = i + 1; j < numbers.length; j++) {
//                    if (numbers[j] == numbers[i]) {
//                        count++;
//                        numbers[j] = -1;
//                    }
//                }
//                if (count > 1) {
//                    System.out.println(numbers[i] + "'s - " + (count / 2));
//                }
//            }
//        }

    }
}

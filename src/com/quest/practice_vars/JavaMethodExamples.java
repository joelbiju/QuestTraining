package com.quest.practice_vars;

public class JavaMethodExamples {
    private static final int X=50;
    public static void main(String[] args) {

        JavaMethodExamples javaMethodExamples=new JavaMethodExamples();
        javaMethodExamples.display("Hello World");
        int result = javaMethodExamples.add(3,5);
        System.out.println(result);
    }

    /**
     * displays string
     * @param str - name
     */
    private void display(String str){
        System.out.println(str);
    }

    /**
     * calculate sum
     * @param a - variable 1
     * @param b - variable 2
     * @return - sum
     */
    private int add(int a, int b){
        return a + b;
    }
}

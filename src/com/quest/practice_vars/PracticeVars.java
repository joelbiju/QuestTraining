package com.quest.practice_vars;

public class PracticeVars {

    final static int VOTE_AGE=18;

    public static void main(String[] args) {
        int age =18;
        double salary = 20000.00;
        char gender = 'M';
        String name = "Joel Biju";

        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Gender: " + gender);
        System.out.println("Name: " + name);

        age=20;
        System.out.println("Age: " + age);
        System.out.println("Vote Age: " + VOTE_AGE);
//        VOTE_AGE=22;    //it cannot be changed since VOTE_AGE is final

        practiceConversion();
        stringConcatenation();
        stringMethods();
    }

    private static void practiceConversion(){
        int a=20;
        double b=25.5;
        double sum=a+b;
        int round=(int)b; //implicit conversion
        System.out.println("Sum: " + sum);
        System.out.println("Round: " + round);
    }

    private static void stringConcatenation(){
        String firstName="John";
        String lastName="Smith";
        String Name=firstName+" "+lastName;
        System.out.println(Name);
        int age=20;
        System.out.println("Name:" + Name + " Age: " + age);
    }

    private static void stringMethods(){
        String s1="Smith";
        String s2="Doe";
        String s3=new String("Hello World");
        String s4=new String("Hello World");
        System.out.println(s3.length());
        System.out.println(s3.equals(s2));  //checks the value to two variables
        System.out.println(s4==s3); //checks reference of two variables
        System.out.println(s4.equalsIgnoreCase(s3)); //checks reference of two variables
        System.out.println(s4.equals(s3));

    }

}

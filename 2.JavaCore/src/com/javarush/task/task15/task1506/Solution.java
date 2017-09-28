package com.javarush.task.task15.task1506;

/* 
Что-то лишнее

Это double
Это Object
Это double
Это Integer
Это double

*/

public class Solution {
    public static void main(String[] args) {
        print((short) 1);
        print((Number) 1);
        print(1);
        print((Integer) 1);
        print((int) 1);
    }

    public static void print(Integer i) { //Integer 4
        System.out.println("Это Integer");
    }

   /* public static void print(int i) {
        System.out.println("Это Integer");
    }

  /*  public static void print(Short i) {
        System.out.println("Это Object");
    }
*/
    public static void print(Object i) { // Object 2
        System.out.println("Это Object");
    }

    public static void print(double i) { //double 1 3 5
        System.out.println("Это double");
    }

/*    public static void print(Double i) {
        System.out.println("Это double");
    }

  /*  public static void print(float i) {
        System.out.println("Это Double");
    }*/
}

package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        closeToTen(8, 11);
        closeToTen(14, 7);
    }

    public static void closeToTen(int a, int b) {
        //::CODE:
        int d1 = abs(10-a);
        int d2 = abs(10-b);

        if (d1>d2) System.out.println(b);
        if(d2>d1) System.out.println(a);
        if(d2==d1) System.out.println(a);

    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}
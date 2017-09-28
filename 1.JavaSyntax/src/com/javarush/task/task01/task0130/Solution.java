package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertCelsiumToFahrenheit(40));
    }

    public static double convertCelsiumToFahrenheit(int celsium) {
        //напишите тут ваш код
        //TC = (TF – 32) * 5/9
        int TC = celsium;
        double TF;
        TF = 1.0*TC/5*9+32;
        return TF;
    }
}
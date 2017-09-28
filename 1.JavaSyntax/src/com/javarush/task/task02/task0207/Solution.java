package com.javarush.task.task02.task0207;

/* 
Кусочек калькулятора
*/
public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int a = 1, b = 100;
        System.out.println(sum(a,b));
        System.out.println(mul(a,b));
    }
    public static int sum(int a, int b){
        return a+b;
    }
    public static int mul(int a, int b){
        return a*b;
    }
}

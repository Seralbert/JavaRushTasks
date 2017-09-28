package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        /*int chk = 1;
        if(a+b<c)chk = 0;
        if(b+c<a)chk = 0;
        if(c+a<b)chk = 0;

        if(chk == 1) System.out.println("Треугольник существует.");
        else System.out.println("Треугольник не существует.");*/

        if(a<b+c & b<a+c & c<a+b) System.out.println("Треугольник существует.");
        else System.out.println("Треугольник не существует.");
    }


}
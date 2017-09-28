package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int digit = Integer.parseInt(reader.readLine());

        if (digit>0)digit = digit *2;
        if (digit<0)digit = digit + 1;
        if (digit == 0)digit = 0;

        System.out.println(digit);


    }

}
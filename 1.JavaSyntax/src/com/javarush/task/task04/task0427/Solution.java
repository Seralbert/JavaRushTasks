package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inp = reader.readLine();
        int len = inp.length();

        int digit = Integer.parseInt(inp);

        //boolean isPositive = false;
        //boolean isNull = false;
        boolean isEven = false;


        if(digit > 0 & digit <= 999) {
            //if (digit == 0) isNull = true;
            //else {
                if (digit % 2 == 0) isEven = true;
                //if (digit > 0) isPositive = true;
            //}

            String res;
            //if (isNull) res = "ноль";
            //else {
                /*if (isPositive) res = "положительное";
                else res = "отрицательное";*/
                if (isEven) res = "четное";
                else res = "нечетное";
            switch (len){
                case 1:res += " однозначное число";
                    break;
                case 2:res += " двузначное число";
                    break;
                case 3:res += " трехзначное число";
                    break;
            }
            //}
            System.out.println(res);
        }
    }
}

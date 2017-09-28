package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String line = reader.readLine();
            if (line.equals("exit"))break;
            if(isNumber(line)) {
                if(line.contains(".")) {
                    double d = Double.parseDouble(line);
                    print(d);
                }
                else {
                    int i = Integer.parseInt(line);
                    if(i>0 && i <128)print((short)i);
                    if(i>=128 || i<=0)print(i);
                }



            }
            else print(line);
        }
    }
    public static boolean isNumber(String s){
        try
        {
            double d = Double.parseDouble(s);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

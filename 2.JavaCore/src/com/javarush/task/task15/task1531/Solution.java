package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input;
        while (true) {
            input = Integer.parseInt(reader.readLine());
            if(input <= 150) break;

        }
            reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        String res = "";
        if (n<0)res = "0";
        if (n == 0) res = "1";
        if (n > 0) {


            BigInteger mult = BigInteger.valueOf(1);
            for (int i = 1; i <= n; i++) {
                mult = mult.multiply(BigInteger.valueOf(i));
                //System.out.println(mult);
            }
            res = mult + "";
        }
        return res;
    }
}

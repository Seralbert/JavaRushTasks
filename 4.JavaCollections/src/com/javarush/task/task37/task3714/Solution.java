package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int currVal = 0, prevVal = 0, subTotal = 0, total = 0;
        for (int i = 0; i < s.length(); i++) {
            currVal = valueOf(s.charAt(i));
            if (currVal > 0) {
                if (prevVal == 0) {
                    subTotal = currVal;
                }
                else if (currVal > prevVal) {
                    total += (currVal - subTotal);
                    subTotal = 0;
                }
                else if (currVal < prevVal) {
                    total += subTotal;
                    subTotal = currVal;
                }
                else if (currVal == prevVal) {
                    subTotal += currVal;
                }
                prevVal = currVal;
            }
        }
        total += subTotal;
        return total;
    }

    private static int valueOf(char c) {
        if (c == 'M') {
            return 1000;
        } else if (c == 'D') {
            return 500;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'I') {
            return 1;
        }
        return 0;
    }
}

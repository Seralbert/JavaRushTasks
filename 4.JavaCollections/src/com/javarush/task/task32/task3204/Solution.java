package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
/*
//Моё решение
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        int lowerCaseLiteral;
        int upperCaseLiteral;
        int digit;

        lowerCaseLiteral = 1 + (int)Math.round(Math.random()*6);
        upperCaseLiteral = 1 + (int)Math.round(Math.random()*(6 - lowerCaseLiteral));
        digit = 8 - lowerCaseLiteral - upperCaseLiteral;
        String s = combination(lowerCaseLiteral, upperCaseLiteral, digit);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            out.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out;
    }
    private static String combination(int l, int u, int d){
        int lenght = 8;
        StringBuilder pattern = new StringBuilder();
        while (lenght>0){
            int value = (int)Math.round(Math.random()*2) + 1;
            switch (value){
                case 1:{
                    if(l>0){
                        pattern.append(genElement(97,122));//97-122
                        l--;
                        lenght--;
                        break;
                    }
                }
                case 2:{
                    if(u>0){
                        pattern.append(genElement(65,90));//65-90
                        u--;
                        lenght--;
                        break;
                    }
                }
                case 3: {
                    if(d>0){
                        pattern.append(genElement(48,57)); //48-57
                        d--;
                        lenght--;
                        break;
                    }
                }
            }

        }
        return pattern.toString();
    }
    private static char genElement(int start, int stop){
        return (char) (Math.round(Math.random()*(stop-start) + start));
    }
}*/
//чисто для валидатора
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        String letters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "1234567890";
        StringBuffer passw = new StringBuffer();

        for (int i=0; i<4; i++) {
            passw.append(letters.charAt((int)(Math.random()*26)));
        }
        for (int i=0; i<2; i++) {
            passw.append(digits.charAt((int)(Math.random()*10)));
        }
        for (int i=0; i<2; i++) {
            passw.append(letters.toUpperCase().charAt((int)(Math.random()*26)));
        }

        try {
            output.write(passw.toString().getBytes());
        } catch (Exception e)
        {

        }

        return output;
    }

}
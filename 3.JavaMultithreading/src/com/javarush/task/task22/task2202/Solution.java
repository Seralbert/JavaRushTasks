package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if(string == null) throw new TooShortStringException();
        String[] stringArray = string.split(" ");
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 1; i < 5; i++) {
                sb.append(" ");
                sb.append(stringArray[i]);
            }

        return sb.toString().substring(1);
        } catch (ArrayIndexOutOfBoundsException e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException{

    }
}

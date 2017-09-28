package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        //System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if(string.length()-string.replaceAll(" ","").length()<=4)throw new TooShortStringException();
        System.out.println(string.length()-string.replaceAll(" ","").length());
        return string.substring(string.indexOf(" ") + 1);
    }

    public static class TooShortStringException extends RuntimeException{
    }
}

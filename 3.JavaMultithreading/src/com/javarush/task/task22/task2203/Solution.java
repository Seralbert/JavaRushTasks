package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string==null){throw new TooShortStringException();}
        String i = string.replaceAll("\t","");
        if(string.length() - i.length()<2) {throw new TooShortStringException();}
        return string.split("\t")[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString("\tJavaRush - лучший сервис."));
    }
}

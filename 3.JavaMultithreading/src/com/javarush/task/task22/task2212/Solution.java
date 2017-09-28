package com.javarush.task.task22.task2212;

import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
//    public static boolean checkTelNumber(String telNumber) {
    public static void checkTelNumber(String telNumber) {
        Pattern p = Pattern.compile("^\\+?[0-9]{2}\\(?[0-9]{3}\\)?[0-9]{7}$");
        Matcher m = p.matcher(telNumber);
        System.out.println(telNumber);
        if (m.matches()) System.out.println("1 plus 12 digit");
        else System.out.println("Kosyak");

        //return false;
    }

    public static void main(String[] args) {
        //checkTelNumber("+38(050)1234567");
        checkTelNumber("+38(050)1234567");
    }
}

package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String date = "MAY 1 2000";
        DateFormat mForm = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH);
        DateFormat mForm1 = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        Date mDate = mForm.parse(date);
        String test = mForm1.format(mDate);
        System.out.println(test.toUpperCase());
        Map<String, String> mCal = new HashMap<String, String>();
        mCal.put("JANUARY","1");
        mCal.put("FEBRUARY","2");
        mCal.put("Mar","3");
        mCal.put("Avr","4");
        mCal.put("May","5");
        mCal.put("Jun","6");
        mCal.put("Jul","7");
        mCal.put("Aug","8");
        mCal.put("Sep","9");
        mCal.put("Okt","10");
        mCal.put("Nov","11");
        mCal.put("Dec","12");
        System.out.println(mCal.get("Dec"));

        for (Map.Entry<String, String> pair: mCal.entrySet())
        {
            //if (pair.getKey().equals(date))
            //System.out.println(date + " is " + pair.getValue() + " month");
            //map.remove(pair.getKey());
            //Integer.parseInt(pair.getValue())%2!=0;
        }

    }

}

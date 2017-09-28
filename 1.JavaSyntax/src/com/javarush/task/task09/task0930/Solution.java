package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        boolean mTrue = isGreaterThan("не", "умею");
        ArrayList<Boolean> key = new ArrayList<>();
        ArrayList<Integer> iArr = new ArrayList<>();
        ArrayList<String> sArr = new ArrayList<>();

        int iCount = 0;
        int sCount = 0;
        for (String s : array){
            if (isNumber(s)){
                key.add(true);
                iArr.add(Integer.parseInt(s));
                //iCount++;
            }
            else {
                key.add(false);
                sArr.add(s);
                //sCount++;
            }
        }
        //System.out.println(iCount + " " + sCount);

        Collections.sort(iArr);
        Collections.reverse(iArr);
        Collections.sort(sArr);
        //int i = 0;
        for ( boolean k : key)
        {
                if(k){
                    array[iCount+sCount]=iArr.get(iCount).toString();
                    iCount++;}
                else {
                    array[iCount+sCount]=sArr.get(sCount);
                    sCount++;}

        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}

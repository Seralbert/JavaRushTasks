package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        //String[] sArray = new String[10];
        ArrayList<String> sArray = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            sArray.add(reader.readLine());
        }


        String minString = sArray.get(0);
        String maxString = sArray.get(0);

        int minIndex = 0;
        int maxIndex = 0;

        for (String s : sArray) {
            if(s.length()<minString.length()){
                minString = s;
                minIndex = sArray.indexOf(s);
            }
            if(s.length()>maxString.length()) {
                maxString = s;
                maxIndex = sArray.indexOf(s);
            }
        }


        if(minIndex<maxIndex) System.out.println(sArray.get(minIndex));
        else System.out.println(sArray.get(maxIndex));
    }
}

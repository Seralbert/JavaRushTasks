package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
1. Введи с клавиатуры 10 слов в список строк.
2. Определить, является ли список упорядоченным по возрастанию длины строки.
3. В случае отрицательного ответа вывести на экран номер первого элемента, нарушающего такую упорядоченность.

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> sArray = new ArrayList<>();
        //String s = "";
        for (int i = 0; i < 10; i++) {
            sArray.add(reader.readLine());
            //s+="1";
            //sArray.add(s);
        }

        //int chk = 0;
        int lenStr = sArray.get(0).length(); // первый;
        for (int i = 1; i < 10; i++){
            if(lenStr<sArray.get(i).length()) {
                lenStr = sArray.get(i).length();
                //System.out.println(lenStr);
            }
            else {
                System.out.println(i);
                break;
            }

            //System.out.println(sArray.get(i)+ " длина:"+ sArray.get(i).length());
        }


    }
}


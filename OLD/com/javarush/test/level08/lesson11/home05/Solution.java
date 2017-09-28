package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] marr;

        //напишите тут ваш код
        ArrayList<String> ma = new ArrayList<String>();
        marr = s.split(" ");
        //System.out.println(marr.length);
        for(String a: marr){
            int count = 0;
            String tmp = "";
            for(char c : a.toCharArray()){

                if(count == 0)
                {
                    //System.out.println(Character.toUpperCase(c));
                    tmp+=Character.toUpperCase(c);
                    count++;
                }else {
                    tmp+=c;
                    //System.out.println(c);
                     }
            }
            ma.add(tmp);
            //System.out.println(a);
        }
        for (String res : ma){
            System.out.print(res+ " ");
        }

    }


}

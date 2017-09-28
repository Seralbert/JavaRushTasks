package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        LinkedList<String> arr = new LinkedList<String>();
        for(int i = 0; i < n; i++)
        {
            //напишите тут ваш код
            arr.add(reader.readLine());
        }
        String s;
        for (int i = 0; i < m; i++)
        {
            s = arr.get(0);
            arr.remove(0);
            arr.add(s);
        }
        for (String l : arr)
        {
            System.out.println(l);
        }
    }
}

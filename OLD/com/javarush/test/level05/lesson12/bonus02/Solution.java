package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> marray = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
        {
            marray.add(Integer.parseInt(reader.readLine()));
        }


        int minimum = marray.get(0);
        for (int i = 1; i < 5; i++)
        {

            if (min(minimum, marray.get(i)) != minimum)
            {
                minimum = marray.get(i);
            }
        }
        System.out.println("Minimum = " + minimum);

    }

    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }

}

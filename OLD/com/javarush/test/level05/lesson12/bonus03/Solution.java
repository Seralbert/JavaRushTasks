package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;
import java.util.ArrayList;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N;
        for (; true; )
        {
            N = Integer.parseInt(reader.readLine());
            if (N > 0) break;
        }

        ArrayList<Integer> marray = new ArrayList<Integer>();
        for (int i = 0; i < N; i++)
        {
            marray.add(Integer.parseInt(reader.readLine()));
        }
        int maximum = marray.get(0);

        for (int i = 1; i < N; i++)
        {
            if (maximum < marray.get(i)) maximum = marray.get(i);
        }
        //напишите тут ваш код


        System.out.println(maximum);
    }
}

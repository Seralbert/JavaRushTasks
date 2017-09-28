package com.javarush.test.level07.lesson12.bonus03;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
        /* Этот алгоритм работает
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            arr.add(array[i]);
        }
        Collections.sort(arr, Collections.reverseOrder());
        int i =0;
        for(int a : arr)
        {
            array[i] = a;
            i++;
        }*/
        Arrays.sort(array);
        int tmp;
        for (int i = 0; i < 10; i++)
        {
            tmp = array[i];
            array[i] = array[19-i];
            array[19-i] = tmp;
        }

    }
}

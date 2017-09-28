package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        LinkedList<String> arr = new LinkedList<String>();

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++)
        {
            arr.add(r.readLine());
        }

        String s;

        for (int i = 0; i < 13; i++)
        {
            s = arr.get(4);
            arr.remove(4);
            arr.add(0,s);
        }

        for (int i = 0; i < 5; i++)
        {
            System.out.println(arr.get(i));
        }

    }
}

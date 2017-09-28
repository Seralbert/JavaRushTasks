package com.javarush.test.level07.lesson06.task01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код

        ArrayList<String> arr = new ArrayList<String>();
       // BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
        {
            //arr.add(r.readLine());
            arr.add(i,"FuCk!!!");
        }

        System.out.println(arr.size());

        for (int i = 0; i < arr.size(); i++)
        {
            System.out.println(arr.get(i));
        }

    }
}

package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/* Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк. Удали 3 - ий элемент списка, и выведи оставшиеся элементы в обратном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> arr = new LinkedList<String>();

        for (int i = 0; i < 5; i++)
        {
            arr.add(r.readLine());
        }
        arr.remove(2);
        for (int i = 0; i < arr.size(); i++)
        {
            System.out.println(arr.get(arr.size()-i -1));
        }

    }
}

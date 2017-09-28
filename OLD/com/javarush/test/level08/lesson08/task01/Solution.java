package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        HashSet<String> arr = new HashSet<String>();

        for (int i = 0; i < 20; i++)
        {
            //String s = "Л"+i;
            arr.add("Л" + i);
        }
        return  arr;
    }
}

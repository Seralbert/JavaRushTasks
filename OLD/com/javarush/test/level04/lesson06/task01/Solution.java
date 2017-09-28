package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String a = buff.readLine();
        String b = buff.readLine();

        if (Integer.parseInt(a)<Integer.parseInt(b))
            System.out.print(a);
        else
            System.out.print(b);
    }
}
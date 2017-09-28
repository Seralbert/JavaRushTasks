package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int a,b,c,d;

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(buff.readLine());
        b = Integer.parseInt(buff.readLine());
        c = Integer.parseInt(buff.readLine());
        d = Integer.parseInt(buff.readLine());

        System.out.print(e(e(a,b),e(c,d)));
    }
    public static int e(int v1, int v2)
    {
        if (v1<v2)
            return v2;
        else
            return v1;
    }
}

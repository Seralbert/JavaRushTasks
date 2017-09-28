package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int v1 = Integer.parseInt(b.readLine());
        int v2 = Integer.parseInt(b.readLine());
        int v3 = Integer.parseInt(b.readLine());

        if ((v1 < v2) && (v1 < v3))
        {
            if (v2 < v3) System.out.println(v2);
            else System.out.println(v3);
        }
        if ((v2 < v1) && (v2 < v3))
        {
            if (v1 < v3) System.out.println(v1);
            else System.out.println(v3);
        }
        if ((v3 < v1) && (v3 < v2))
        {
            if (v1 < v2) System.out.println(v1);
            else System.out.println(v2);
        }
    }
}
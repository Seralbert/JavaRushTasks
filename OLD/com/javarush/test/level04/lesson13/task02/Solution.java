package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(b.readLine()); // col
        int n = Integer.parseInt(b.readLine()); // row


        String v = "";

        for (int j = 1; j <= n; j++)
        {
            v = v + "8";
        }

        for (int i = 1;i<=m;i++)
        {
          System.out.println(v);
        }
     //   //напишите тут ваш код


    }
}

package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int n1,n2,n3;

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        n1 = Integer.parseInt(buff.readLine());
        n2 = Integer.parseInt(buff.readLine());
        n3 = Integer.parseInt(buff.readLine());

        //напишите тут ваш код
        if (n1 > n2 && n1 > n3 && n2 > n3)
            System.out.print(n1 +" " + n2 + " " + n3);
        else   if (n2 > n1 && n2 > n3 && n1 > n3)
            System.out.print(n2 + " " + n1 + " " + n3);
        else   if (n3 > n1 && n3 > n2 && n2 > n1)
            System.out.print(n3 + " " + n2 + " " + n1);
        else   if (n3 > n1 && n3 > n2 && n1 > n2)
            System.out.print(n3 + " " + n1 + " "+ n2);
        else  if (n2 > n1 && n2 > n3 && n3 > n1)
            System.out.print(n2 + " " + n3 + " "+ n1);
        else  if (n1 > n2 && n1 > n3 && n3 > n2)
            System.out.print(n1 + " " + n3 + " "+ n2);
    }

}

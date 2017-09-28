package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int istr, isumm = 0;
        String isCache = "0";
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        for( ;true; )
        {
            isCache = b.readLine();

            istr = Integer.parseInt(isCache);

            if(istr == -1) break;
            else
                isumm += istr;
        }
        isumm--;
        System.out.println(isumm);
        //напишите тут ваш код
    }
    /*public static int sum(int mdate)
    {
        //mdate = mdate + mdate;
        return mdate;
    }*/
}

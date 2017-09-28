package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] bmass = new int[20];
        int[] smass1 = new int[10];
        int[] smass2 = new int[10];
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++)
        {
            bmass[i] = Integer.parseInt(r.readLine());
        if(i < 10)smass1[i] = bmass[i];
        else smass2[i-10] = bmass[i];
        }

        for (int i = 0; i < 10; i++)
        {
            System.out.println(smass2[i]);
        }
    }
}

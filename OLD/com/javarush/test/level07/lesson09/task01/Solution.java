package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> doub = new ArrayList<Integer>();
        ArrayList<Integer> treb = new ArrayList<Integer>();
        ArrayList<Integer> other = new ArrayList<Integer>();

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++)
        {
            int v = Integer.parseInt(r.readLine());
            arr1.add(v);
            if(v%2 == 0) doub.add(v);
            if(v%3 == 0) treb.add(v);
            if(v%2 != 0 && v%3 != 0) other.add(v);
        }
        printList(treb);
        printList(doub);
        printList(other);
    }

    public static void printList(ArrayList<Integer> list)
    {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}

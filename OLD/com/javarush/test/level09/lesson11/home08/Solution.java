package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        int[] arr5 = {0,1,2,3,4};
        int[] arr2 = {1,2};
        int[] arr4 = {1,2,3,4};
        int[] arr7 = {1,2,3,4,5,6,7};
        int[] arr0 = {};

        ArrayList<int[]> intArr = new ArrayList<int[]>();

        intArr.add(arr5);
        intArr.add(arr2);
        intArr.add(arr4);
        intArr.add(arr7);
        intArr.add(arr0);

        return intArr;

    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}

package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int len = array.length;
        Arrays.sort(array);
        final double median = len % 2 == 0 ? (double) (array[len / 2] + array[len / 2 - 1]) / 2 : array[len / 2];
        Comparator<Integer> compareByMedian = (o1, o2) -> (int) (Math.abs(o1 - median)-Math.abs(o2 - median));

        Arrays.sort(array, compareByMedian);

        return array;
    }
}

package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
«отрицательное четное число» — если число отрицательное и четное,
«отрицательное нечетное число» — если число отрицательное и нечетное,
«ноль» — если число равно 0,
«положительное четное число» — если число положительное и четное,
«положительное нечетное число» — если число положительное и нечетное.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int digit = Integer.parseInt(reader.readLine());

        boolean isPositive = false;
        boolean isNull = false;
        boolean isEven = false;

        if(digit == 0)isNull = true;
        else
        {
            if(digit%2==0)isEven = true;
            if(digit>0)isPositive = true;
        }

        String res = "";
        if(isNull) res = "ноль";else {
            if (isPositive) res = "положительное";
            else res = "отрицательное";
            if(isEven) res +=" четное число";
            else res +=" нечетное число";
        }
        System.out.println(res);
    }
}

package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner reader = new Scanner(System.in);
        ArrayList<Integer> iArray = new ArrayList<>();
        int num;
        while ((num=reader.nextInt())!=-1){
            iArray.add(num);
        }
        double summ = 0;
        for (int i : iArray){
            summ += (double)i;
        }
        System.out.println(summ/iArray.size());
    }
}


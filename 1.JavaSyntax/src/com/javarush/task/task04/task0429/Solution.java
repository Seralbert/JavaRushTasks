package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> iArray = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
                        iArray.add(Integer.parseInt(reader.readLine()));
        }

        int pCount = 0;
        int nCount = 0;

        for (int i : iArray){
            if (i > 0) pCount++;
            if (i < 0) nCount++;
        }
        System.out.println("количество отрицательных чисел: "+nCount);
        System.out.println("количество положительных чисел: "+pCount);

    }
}

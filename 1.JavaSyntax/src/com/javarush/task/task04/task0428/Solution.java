package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> mArray = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mArray.add(Integer.parseInt(reader.readLine()));
        }
        int count= 0;
        for (int chk : mArray){
            if (chk>0)count++;
        }
        System.out.println(count);
    }
}

package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());

        int square = 0;

        if(x>0 & y>0) System.out.println(square=1);//1
        if(x>0 & y<0) System.out.println(square=4);//4
        if(x<0 & y>0) System.out.println(square=2);//2
        if(x<0 & y<0) System.out.println(square=3);//3
    }
}

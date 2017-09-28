package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner reader = new Scanner(System.in);
        double min = reader.nextDouble();
        double chk = min%5;
        if(chk>=0 & chk <3) System.out.println("зелёный");
        if(chk>=3 & chk <4) System.out.println("желтый");
        if(chk>=4 & chk <5) System.out.println("красный");
        //System.out.println(chk);

    }
    /*
    * 0-3 green
    * 3-4 yellow
    * 4-5 red
    *
    * полный цикл 5 мин
    * */
}
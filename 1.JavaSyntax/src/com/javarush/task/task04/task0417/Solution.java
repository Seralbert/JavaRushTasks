package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner reader = new Scanner(System.in);
        int i1 = reader.nextInt();
        int i2 = reader.nextInt();
        int i3 = reader.nextInt();
        //все 3
        if (i1==i2 && i2==i3) System.out.println(i1 + " " + i2 + " " + i3);
        else {
            //есть пара
            if (i1 == i2) System.out.println(i1 + " " + i2);
            if (i2 == i3) System.out.println(i2 + " " + i3);
            if (i1 == i3) System.out.println(i1 + " " + i3);
        }
    }
}
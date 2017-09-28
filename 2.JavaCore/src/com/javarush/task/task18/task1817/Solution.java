package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int count = 0;
        int space = 0;
        int n;
        while ((n = fileInputStream.read()) != -1){
            String s = String.valueOf((char)n);

            if(s.equals(" ")){
                count++;space++;
            }else count++;
        }
        double res = 1.0*space/count*100;
        fileInputStream.close();
        System.out.printf("%.2f",res);
    }
}

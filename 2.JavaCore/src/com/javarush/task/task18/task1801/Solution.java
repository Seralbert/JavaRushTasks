package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        byte maxByte = 0;
        byte currientByte;
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        while (fileInputStream.available()>0){
            currientByte = (byte) fileInputStream.read();
            if(maxByte< currientByte)maxByte = currientByte;
        }
        reader.close();fileInputStream.close();
        System.out.println(maxByte);
    }
}

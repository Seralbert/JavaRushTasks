package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        byte minByte = (byte)fileInputStream.read();
        byte currientByte;
        while (fileInputStream.available()>0){
            currientByte = (byte) fileInputStream.read();
            if(minByte > currientByte)minByte = currientByte;
        }
        reader.close();fileInputStream.close();
        System.out.println(minByte);
    }
}

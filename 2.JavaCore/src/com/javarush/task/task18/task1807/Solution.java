package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception{
        //"," - 44 2Ch
        char dotedComma = 44;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();

        if (inputStream.available() > 0)//1
        {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int read = inputStream.read(buffer);
            int count = 0;
            for (byte b : buffer){
                if((char)b == dotedComma)count++;
            }
            System.out.println(count);
        }

        inputStream.close();
        //System.out.println(dotedComma);
    }
}

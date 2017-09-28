package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();

        Set<Byte> sortedSet = new TreeSet<>();
        while (fileInputStream.available() > 0) {
            byte chkByte = (byte) fileInputStream.read();
            sortedSet.add(chkByte);
        }
        fileInputStream.close();
        for (byte b : sortedSet){
            System.out.print(b + " ");
        }
        }catch (IndexOutOfBoundsException | FileNotFoundException e){e.printStackTrace();}


    }
}

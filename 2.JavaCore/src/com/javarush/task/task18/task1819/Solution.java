package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner readName = new Scanner(System.in);
        String file1 = readName.next();
        String file2 = readName.next();

        FileInputStream source = new FileInputStream(file1);
        ArrayList<Integer> buffer = new ArrayList<>();
        while (source.available()>0){
            int data = source.read();
            buffer.add(data);
        }
        source.close();
        source = new FileInputStream(file2);
        FileOutputStream dest = new FileOutputStream(file1);
        while (source.available()>0){
            int data = source.read();
            dest.write(data);
        }
        for (int b : buffer){
            dest.write(b);
        }

        source.close();dest.close();
    }
}

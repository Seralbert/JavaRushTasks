package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner reader = new Scanner(System.in);
        BufferedReader bfr = new BufferedReader(new FileReader(reader.next()));
        reader.close();


        String line;
        while ((line = bfr.readLine())!=null){
        String[] tmp = line.split(" ");
            if (tmp[0].equals(args[0])) System.out.println(line);
        }
        bfr.close();

    }
}

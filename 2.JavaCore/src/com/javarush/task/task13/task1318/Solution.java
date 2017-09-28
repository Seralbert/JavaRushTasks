package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        InputStream inputStream = new FileInputStream(filename);
        while (inputStream.available()>0){
            System.out.print((char)inputStream.read());
        }
        inputStream.close();
        reader.close();
        System.out.println();
        // Супер решение
//       Files.lines(Paths.get(fullPath), StandardCharsets.UTF_8).forEach(System.out::println);
    }
}
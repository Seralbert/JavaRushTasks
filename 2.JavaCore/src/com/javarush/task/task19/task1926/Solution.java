package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
//        String test = "Привет - это я";
//        System.out.println(rev(test));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()){
            System.out.println(rev(br.readLine()));
        }
        br.close();

    }
    public static String rev(String s){
        return new StringBuilder(s).reverse().toString();
    }
}

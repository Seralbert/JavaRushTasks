package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;

public class Solution {
//    public static ArrayList<String> separator = new ArrayList<>();
//    static {
//        separator.add(".");
//        separator.add(",");
///*
//        separator.add(";");
//        separator.add("!");
//        separator.add("?");
//*/
//    }

    public static void main(String[] args) throws IOException{
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        int count = 0;
        FileReader fr = new FileReader(fileName);
        int ch;
        String word ="";
    while ((ch = fr.read())!=-1){
        if(!separator.contains(String.valueOf(ch))) word += (char)ch;
        else {
            if(word.equals("world"))count++;
            word = "";
        }

    }
        fr.close();
        System.out.println(count);
*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name=reader.readLine();
        reader.close();

        BufferedReader fis = new BufferedReader(new FileReader(name));
        int count = 0;
        String s = "";
        while(fis.ready()) s += fis.readLine() + ",";
        s = s.replaceAll("[^A-Za-z]", ",");

        String[] s1=s.split(",");
        for (String w : s1)if(w.equals("world"))count++;

        fis.close();
        System.out.println(count);
    }
}

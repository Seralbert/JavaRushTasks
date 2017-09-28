package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException {
        String test = "Info about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela\n" +
                "</span></b></span><span>Super</span><span>girl</span>";
        String chk = "span";

       // System.out.println(test);

        String newString = test.replaceAll("\\n", "" );
        System.out.println(newString);
        String[] word = newString.split("<"+chk);
        for (String s : word){
            System.out.println(s);
        }

        /*String openTag = "<"+args[0];
        String closeTag = "</"+args[0];
        Pattern p = Pattern.compile("<"+args[0])
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

            fileName = reader.readLine();
            reader.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        StringBuilder sb = new StringBuilder();
        while (br.ready()){
            sb.append(br.readLine());
        }
        br.close();
        line = sb.toString();*/
    }
}

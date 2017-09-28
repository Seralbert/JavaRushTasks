package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{

        //System.out.println(chkString("Вфайл"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while (br.ready()){
            if(chkString(line = br.readLine())) System.out.println(line);
        }
        br.close();
        //chkString("sdasd");
    }


    public static boolean chkString(String str){
        //String str = "abcabcabc";
        String substr = "";// = words.get(0) + "|" + words.get(1) +"|" + words.get(2);
        for(String s : words){
            substr += s + "|";
        }
        substr = substr.substring(0,substr.length()-1);
        Pattern p = Pattern.compile(substr);
        Matcher m = p.matcher(str);
        int counter = 0;
        while(m.find()) {
            counter++;
        }
        //System.out.println(substr);
        return counter==2;//?true:false; //если 2 вхождения
    }

}

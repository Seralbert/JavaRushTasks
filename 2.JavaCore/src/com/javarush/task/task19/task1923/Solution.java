package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException{
        /*String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader br = new BufferedReader(new FileReader(fileName1));
        FileWriter fw = new FileWriter(fileName2);

        String line;
        //String newLine ="";
        Pattern pattern  = Pattern.compile("[0-9]+");
        Matcher matcher;

        while (br.ready()){
            line = br.readLine();
            String[] words = line.split(" ");
            for(String word : words){
                matcher = pattern.matcher(word);
                if(matcher.find())newLine += word + " ";
            }

            fw.write(newLine.trim());
            fw.write("\r\n");
        }
        br.close();
        fw.close();*/

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        // Читаем данные из файла и пишем их в str
        String str = "";
        String results = "";
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m;
        while (reader.ready()) {
            String line = reader.readLine();
            String[] piesesOfLine = line.split(" ");
            // пробегаемся по отдельному слову
            for (String s : piesesOfLine){
                m = p.matcher(s);
                if(m.find()){
                    results += s + " ";
                }
            }

        }
        reader.close();
        FileWriter writer = new FileWriter(args[1]);
        writer.write(results.trim());
        writer.close();
    }
}

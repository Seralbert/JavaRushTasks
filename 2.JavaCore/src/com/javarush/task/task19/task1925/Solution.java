package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        /*String source = "длинное короткое аббревиатура";
        String[] outx = source.split(" ");

        String out ="";
        for(String s : outx){
            out += "," + s;
        }
        System.out.println(out.substring(1));*/
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader br = new BufferedReader(new FileReader(fileName1));
        FileWriter fw = new FileWriter(fileName2);
        String line = "";
        while (br.ready()){
            String[] words = br.readLine().split(" ");
            for (String w : words){
                if(w.length()>6){
                    line += "," + w;
                }
            }
            //fw.write(line.substring(1));
            //line = "";
        }

        br.close();
        fw.write(line.substring(1));
        fw.close();

    }
}

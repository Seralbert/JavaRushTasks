package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = reader.readLine();
        String outFile = reader.readLine();
        reader.close();
        BufferedReader br = new BufferedReader(new FileReader(inFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
        String line;
        boolean firstLine = true;
        while (br.ready()){
            line = br.readLine();
            if(!firstLine){
                bw.newLine();
            }else firstLine = false;
            String newLine = line.replaceAll("\\.","!");
            bw.write(newLine);
        }
        br.close();bw.close();
    }
}


package com.javarush.task.task19.task1910;

/* 
Пунктуация
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
        String sourceData;

        while (br.ready()){
            sourceData = br.readLine();
            String newData = sourceData.replaceAll("[^0-9A-Za-z]","");
            //String newData = sourceData.replaceAll("[,;:\\.\\?!-()\"\r\n]","");
            //newData = newData.replaceAll("\\s+"," ");
            bw.write(newData);
        }
        br.close();bw.close();

    }
}

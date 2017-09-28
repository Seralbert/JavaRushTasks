package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fistFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();

        //ArrayList<String> line = new ArrayList<>();

        FileReader fileReader = new FileReader(fistFile);
        FileWriter fileWriter = new FileWriter(secondFile);
        boolean flag = false;
        int c;
        while ((c = fileReader.read())!=-1){
            if(flag)fileWriter.write((byte)c);
            flag = flag?false:true;
        }
        fileReader.close();fileWriter.close();
    }
}

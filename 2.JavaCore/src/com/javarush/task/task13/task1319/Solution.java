package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String filename = "c:/" + reader.readLine();
        String filename = reader.readLine();
        //System.out.println(filename);

        //String chk = "exit";
        ArrayList<String> fileList = new ArrayList<>();
        String line = "";
        //BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
        BufferedWriter br = new BufferedWriter(new FileWriter(filename));
        //без exit
/*
        while (!(line = reader.readLine()).equals("exit")){
        fileList.add(line);
        }
          */
        // с exit
        while (!line.equals("exit")){
            line = reader.readLine();
            //if(!line.equals("exit")) {
                fileList.add(line);
            //}
        }

        /*for (String l : fileList){
            System.out.println(l);
        }
        */
        /*OutputStream fo = new FileOutputStream(new File(filename));
        for (String fileLine : fileList) {
            fo.write(fileLine.getBytes(),0,fileLine.length());

        }*/


        for (String fileLine : fileList) {
            br.write(fileLine);
            if(!fileLine.equals("exit")) {
                br.newLine();
            }
        }
        reader.close();
        br.close();


    }
}

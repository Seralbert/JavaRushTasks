package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String f1 = rd.readLine();
        String f2 = rd.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(f1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        while (reader.ready()) {
            String [] arr = reader.readLine().split(" ");
            for (String s: arr) {
                try {
                    writer.write(Integer.parseInt(s) + " ");
                }
                catch (Exception e) {
                    continue;
                }
            }
        }
        rd.close();
        reader.close();
        writer.close();
    }


        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(firstFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(secondFile));
        String line = "";

        while (br.ready()){
            line += br.readLine() + " ";
        }
        String[] items = line.split(" ");
        for (String s : items){
            if(isDig(s)){
//                fw.write(s.trim());
//                fw.write(" ");
                line += s + " ";

            }
        }
        bw.write(line);
        br.close();bw.close();

    }
    static boolean  isDig(String word){
        //String word = ""; // "12ф";
        if (word.matches("[0-9]+")) //System.out.println("Число");
            return true;
        else return false;
    }*/
}

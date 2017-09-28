package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        ArrayList<String> listFile = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()) {
            listFile.add(br.readLine());
        }
        br.close();
        String newLine = "";
        for (String s : listFile) {
            String[] line = s.split(" ");
            for (String word : line) {
                try{
                newLine += map.getOrDefault(Integer.parseInt(word), word) + " ";
                }catch (NumberFormatException e){
                    newLine+=word + " ";
                }

            }
            System.out.println(newLine);
            newLine = "";
        }
        /*
        * for (String s : listFile) {
            String[] line = s.split(" ");
            for (String word : line) {
                if (map.containsKey(Integer.parseInt(word))) {
                    newLine += map.get(Integer.parseInt(word));
                } else newLine += word;
            }
            System.out.println(newLine);
            newLine = "";
            }
        */
    }
}

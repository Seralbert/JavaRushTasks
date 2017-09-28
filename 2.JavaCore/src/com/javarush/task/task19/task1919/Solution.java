package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String,Double> map = new TreeMap<>();
        String fileName = args[0];

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        String name;
        Double value;
        while (br.ready()){
            line = br.readLine();

            name = line.split(" ")[0];
            value = Double.parseDouble(line.split(" ")[1]);

            if(map.containsKey(name)){
                map.put(name,map.get(name)+ value);
            } else {
                map.put(name,value);
            }
        }

        br.close();

        for (Map.Entry<String, Double> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

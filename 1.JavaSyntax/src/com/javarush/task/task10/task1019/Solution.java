package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int id ;
        String name;
        String tmp;
        HashMap<String,Integer> hMap = new HashMap<>();
        while(true) {
            tmp = reader.readLine();
            if(tmp.isEmpty())break;
            id = Integer.parseInt(tmp);
            name = reader.readLine();
            if(name.isEmpty())break;

            hMap.put(name,id);
            //System.out.println("Id=" + id + " Name=" + name);
        }
        for (Map.Entry<String,Integer> entry : hMap.entrySet()){
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}

package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Решение без MAP
while (fis.available() > 0) {
                int temp = fis.read();
                arr[temp] = arr[temp] + 1;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    System.out.println((char)i + " " + arr[i]);
                }
            }
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static Map<Character,Integer> acsiiMap = new TreeMap<>();
    public static void main(String[] args) throws IOException{
        initMap();

        FileInputStream fi = new FileInputStream(args[0]);
        while (fi.available()>0){
            int b = fi.read();
            acsiiMap.put((char)b,acsiiMap.get((char)b)+1);
        }
        fi.close();

        for (Map.Entry<Character,Integer> entry : acsiiMap.entrySet()){
            if(entry.getValue()!= 0)
            System.out.println((entry.getKey()) + " " + entry.getValue());
        }

    }
    public static void initMap(){
        for (char i = 0; i < 255 ; i++){
            acsiiMap.put(i,0);
        }
    }
}

package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        FileReader reader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        while (br.ready()){
            sb.append(br.readLine());
        }
        String inputString = sb.toString();
        inputString = inputString.replaceAll("\\W","").toLowerCase();
        TreeSet<Character> set = new TreeSet<>();

        for(char c : inputString.toCharArray()){
            set.add(c);
        }
        int outChar = set.size()>=5?5:set.size();
        for (int i = 0; i < outChar; i++) {
            System.out.print(set.pollFirst());
        }
    }
}

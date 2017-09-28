package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        try {
            List<String> tmp = getArgs(getParam(readURI()), "&");
            String objV = "";

            for (String s:tmp){
                //System.out.print(s + " ");
                List<String> stmp = getArgs(s, "=");
                System.out.print(stmp.get(0)+ " ");
                if (stmp.get(0).equals("obj")){
                    objV = stmp.get(1);

                }
            }
            if(!objV.equals("")){
                System.out.println();
                callAlert(objV);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void callAlert(String aValue){
        try {
            Double chk = Double.parseDouble(aValue);
            alert(chk);
        } catch (NumberFormatException e){
            alert(aValue);
        }
    }

    public static List<String> getArgs(String s , String sep){
        String[] ss = s.split(sep);
        List<String> args = Arrays.asList(ss);
        return args;
    }


    public static String readURI() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static String getParam(String sURI){
        char[] cURI = sURI.toCharArray();
        String sParam ="";
        boolean id = false;
        for (char c : cURI){
            if(id)sParam += c;
            if(c == '?')id = true;
        }
        return sParam;
    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

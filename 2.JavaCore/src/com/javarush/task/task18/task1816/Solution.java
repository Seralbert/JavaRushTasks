package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/


import java.io.*;
import java.util.regex.Pattern;

public class Solution {
//    public static String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
//    public static char[] eng = alphabet.toCharArray();

    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//        //HashMap<Character, Integer> voc = new HashMap<>();
//
//        int charFormFile;
//        int counter =0;
//        try {
//
//            while ((charFormFile = reader.read())!=-1){
//                if(Arrays.asList(eng).contains(charFormFile))counter++;
////                if(voc.containsKey(charFormFile)){
////                    voc.put((char)charFormFile,voc.get(charFormFile)+1);
////                }else {
////                    if(Arrays.asList(eng).contains(charFormFile)){
////                        voc.put((char)charFormFile,1);
////                    }
////                }
//
//            }
//
//        }catch (IOException e) {e.printStackTrace();}
//        System.out.println(counter);
////        for (Map.Entry<Character,Integer> entry : voc.entrySet()){
////            System.out.println(entry.getKey() + " " + entry.getValue());
////        }
//        reader.close();
        FileInputStream inputStream = new FileInputStream(args[0]);
        int count = 0;
        int n;
        while ((n = inputStream.read()) != -1){
            String s = String.valueOf((char)n);
            Boolean b = Pattern.matches("[a-zA-Z]", s);
            if (b) count++;
        }

        System.out.print(count);
        inputStream.close();
    }
}



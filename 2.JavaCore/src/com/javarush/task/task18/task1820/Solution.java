package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
//        Scanner fileName = new Scanner(System.in);
//        String file1 = fileName.next();
//        String file2 = fileName.next();
//        FileReader inf = new FileReader(file1);
//        BufferedReader reader = new BufferedReader(inf);
//        String line;
//        ArrayList<String> buffer = new ArrayList<>();
//        ArrayList<String> outbuffer = new ArrayList<>();
//        while ((line = reader.readLine())!=null) {
//            buffer.addAll(Arrays.asList(line.split(" ")));
//        }
//        reader.close();inf.close();
//        for (String s : buffer){
//            double tmp = div(Double.parseDouble(s));
//            outbuffer.add(String.valueOf(tmp));
//        }
//        FileWriter outf = new FileWriter(file2);
//
//        for (String s : outbuffer){
//        outf.write(s + " ");
//        }
//        outf.close();
//        //System.out.println(div(-2.5));
//    }
//    public static int div(double d){
//        int i = (int)d;
//        if (d%i > 0.5){
//            i++;
//        }
//        if (d%i < -0.5){
//            i--;
//        }
//
//        //System.out.println("i " + i);
//        return i;
//    }
        Scanner reader = new Scanner(System.in);
        String file1 = reader.next();
        String file2 = reader.next();
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        byte[] bt = new byte[fis.available()];
        fis.read(bt);
        fis.close();
        String[] numbers = new String(bt).split(" ");
        String line = "";

        for (String s : numbers){
            line += Math.round(Double.parseDouble(s)) + " ";
        }
        fos.write(line.trim().getBytes());
        fos.close();
    }
}

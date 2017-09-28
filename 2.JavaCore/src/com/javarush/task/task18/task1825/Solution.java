package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Collections;

public class Solution {
        public static void main(String[] args) throws IOException {
/*
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arrayList = new ArrayList<>();
        String name;
        while(true) {
            name = reader.readLine();
            if("end".equals(name))break;
            arrayList.add(Integer.parseInt(name.split(".part")[1]),name);
        }
        reader.close();
        String nameoutput = arrayList.get(0).split(".part")[0];
        FileInputStream fileRead;
        FileOutputStream fileWrite = new FileOutputStream(nameoutput);
        byte[] buff;

        for (String s : arrayList) {
            fileRead = new FileInputStream(s);
            buff = new byte[fileRead.available()];
            fileRead.read(buff);
            fileWrite.write(buff);
            fileRead.close();
        }
        fileWrite.close();


//        private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
//            Files.copy(source.toPath(), dest.toPath());
//        }*/
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            ArrayList<String> list = new ArrayList<>();
            while (!s.equals("end")) {
                list.add(s);
                s = reader.readLine();
            }
            Collections.sort(list);
            String mainFileName = list.get(0).substring(0, list.get(0).lastIndexOf(".part"));
            FileOutputStream outputStream = new FileOutputStream(mainFileName);
            for (String fileName: list) {
                FileInputStream inputStream = new FileInputStream(fileName);
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                inputStream.close();
                outputStream.write(buffer);
            }
            outputStream.close();
    }
}

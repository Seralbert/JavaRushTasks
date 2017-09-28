package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        FileInputStream fileInputStream = null;
        //boolean isClose = true;
        try {
            while (true) {
                name = reader.readLine();
                try {
                    fileInputStream = new FileInputStream(name);
                    fileInputStream.close();
                    //отлов Ислючения!!!!
                }catch (FileNotFoundException e) {
                    System.out.println(name);
                    reader.close();
                    break;
                    //isClose = false;
                }
            }
        }catch (IOException e){}

    }
}

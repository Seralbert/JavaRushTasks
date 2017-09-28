package com.javarush.task.task18.task1818;

/* 
Два в одном

Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1,file2, file3;

        file1 = reader.readLine();
        file2 = reader.readLine();
        file3 = reader.readLine();

        reader.close();

        FileOutputStream dfile = new FileOutputStream(file1);
        FileInputStream sfile1 = new FileInputStream(file2);
        FileInputStream sfile2 = new FileInputStream(file3);


        while (sfile1.available()>0) {
            int data = sfile1.read();
            dfile.write(data);
        }
        while (sfile2.available()>0) {
            int data = sfile2.read();
            dfile.write(data);
        }

        dfile.close();
        sfile1.close();
        sfile2.close();
    }
}



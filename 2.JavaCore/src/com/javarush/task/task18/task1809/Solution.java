package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            FileInputStream inputStream = new FileInputStream(file1);
            FileOutputStream outputStream = new FileOutputStream(file2);


            if (inputStream.available() > 0)
            {

                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                reverse(buffer);
                outputStream.write(buffer, 0, count);
            }


            outputStream.close();
            inputStream.close();}
        catch (IOException e){e.printStackTrace();}

    }
    public static void reverse(byte[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        byte tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }
}

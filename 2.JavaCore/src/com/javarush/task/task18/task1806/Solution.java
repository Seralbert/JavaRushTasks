package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try{ //4
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");

        //if (inputStream.read() > 0)//1
        if (inputStream.available() > 0)//1
        {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

//        inputStream.reset(); //2
//        outputStream.flush(); //3
        outputStream.close();
        inputStream.close();}
        catch (FileNotFoundException e){e.printStackTrace();}
    }
}

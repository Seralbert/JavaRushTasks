package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        if(args[0].equals("-e")){
//Encode
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            int tmp;
            while (inputStream.available()>0){
                tmp = inputStream.read();
                outputStream.write(encode(tmp));
            }
            inputStream.close();outputStream.close();
        }
        else {
            if (args[0].equals("-d")) {
//Decode
                FileInputStream inputStream = new FileInputStream(args[1]);
                FileOutputStream outputStream = new FileOutputStream(args[2]);
                int tmp;
                while (inputStream.available() > 0) {
                    tmp = inputStream.read();
                    outputStream.write(decode(tmp));
                }
                inputStream.close();
                outputStream.close();
            } else {

            }
        }
    }
    private static int encode(int b){
        return b+1;
    }
    private static int decode(int b){
        return b-1;
    }

}

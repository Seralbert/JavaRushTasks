package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{

//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            String file1 = reader.readLine();
//            String file2 = reader.readLine();
//            String file3 = reader.readLine();
//            reader.close();
//            FileInputStream fileInputStream = new FileInputStream(file1);
//            FileOutputStream fileOutputStream1 = new FileOutputStream(file2);
//            FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
//
//            if (fileInputStream.available() > 0) {
//                byte[] buffer = new byte[fileInputStream.available()];
//                int count = fileInputStream.read(buffer);
//                fileOutputStream1.write(buffer, 0, count / 2);
//                fileOutputStream2.write(buffer, count / 2 + 1, count - count / 2);
////                fileInputStream.close();
////                fileOutputStream1.close();
////                fileOutputStream2.close();
//            }
//            fileInputStream.close();
//            fileOutputStream1.close();
//            fileOutputStream2.close();
//
//        }catch (IndexOutOfBoundsException | IOException e){e.printStackTrace();}
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        FileOutputStream file3 = new FileOutputStream(fileName3);


        byte[] buffer = new byte[file1.available()];
        file1.read(buffer);
        file2.write(buffer, 0, (buffer.length / 2) + (buffer.length % 2));
        file3.write(buffer, (buffer.length / 2) + (buffer.length % 2), (buffer.length / 2));


        file1.close();
        file2.close();
        file3.close();

        reader.close();

    }
}

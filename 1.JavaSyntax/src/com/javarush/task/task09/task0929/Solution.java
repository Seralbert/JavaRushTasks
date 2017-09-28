package com.javarush.task.task09.task0929;

import java.io.*;

/* 
Обогатим код функциональностью!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String chk = "Файл не существует.";
        while (chk.equals("Файл не существует.")) {
            try {
                //System.out.println("Введите имя исходного файла");
                String sourceFileName = reader.readLine();
                //System.out.println("Введите имя целевого файла");
                String destinationFileName = reader.readLine();


                InputStream fileInputStream = getInputStream(sourceFileName);
                chk = "Исходный файл открыт";
                //System.out.println(chk);
                OutputStream fileOutputStream = getOutputStream(destinationFileName);

                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    fileOutputStream.write(data);
                }

                fileInputStream.close();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(chk);
            }
        }
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}


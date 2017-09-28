package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException{
        while (true){
            String name = (new Scanner(System.in).next());
            if (!name.equals("exit")){
                ReadThread rt = new ReadThread(name);
                rt.start();
            }else break;
        }
    }

    public static class ReadThread extends Thread{
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            //this.start();
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                HashMap<Byte,Integer> byteField = new HashMap<>();
                ArrayList<Byte> byteArrayList = new ArrayList<>();
                while (fileInputStream.available()>0){
                    byte chkByte = (byte)fileInputStream.read();
                    if(!byteField.containsKey(chkByte)){
                        byteField.put(chkByte,1);
                        byteArrayList.add(chkByte);
                    }
                    else {
                        byteField.replace(chkByte,byteField.get(chkByte)+1);
                    }

                    //byteField.put(chkByte, byteField.containsKey(chkByte)?byteField.get(chkByte)+1:1);

                }
                int max = 0;
                byte savedKey = 0;
                for (byte b : byteArrayList){
                    if (max < byteField.get(b)) {
                        max = byteField.get(b);
                        savedKey = b;
                    }
                }
                for (Map.Entry <Byte,Integer>entry : byteField.entrySet()){
                    int i = entry.getValue();
                    if(i==max){
                        System.out.print(entry.getKey() + " ");
                    }
                }
                fileInputStream.close();
                resultMap.put(fileName, (int) savedKey);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

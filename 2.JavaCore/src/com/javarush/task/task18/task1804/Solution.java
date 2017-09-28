package com.javarush.task.task18.task1804;

import java.io.*;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {

public static void main(String[] args) throws Exception {
//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    FileInputStream file = new FileInputStream(reader.readLine());
//    try {
//      ArrayList<Byte> listAllBystes = new ArrayList<>();
//      while(file.available()>0) {
//          byte tmp = (byte) file.read();
//          listAllBystes.add(tmp);
//      }
//
//      ArrayList<Byte> bytes = new ArrayList<>();
//      for(byte i : listAllBystes) {
//          if (!bytes.contains(i)) {
//              bytes.add(i);
//          }
//
//          int min = Collections.frequency(listAllBystes, bytes.get(0));
//          for (byte b : bytes) {
//              if (min > Collections.frequency(listAllBystes, b))
//                  min = Collections.frequency(listAllBystes, b);
//          }
//
////          for (byte b : bytes) {
////              if (min == Collections.frequency(listAllBystes, b))
////                  System.out.print(b + " ");
////          }
//
//      }
//
//        } finally{
//            file.close();
//            reader.close();
//        }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    FileInputStream fileInputStream = new FileInputStream(reader.readLine());;
    try {
        HashMap<Byte, Integer> byteField = new HashMap<>();
        ArrayList<Byte> byteArrayList = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            byte chkByte = (byte) fileInputStream.read();
            if (!byteField.containsKey(chkByte)) {
                byteField.put(chkByte, 1);
                byteArrayList.add(chkByte);
            } else {
                byteField.replace(chkByte, byteField.get(chkByte) + 1);
            }

            //byteField.put(chkByte, byteField.containsKey(chkByte)?byteField.get(chkByte)+1:1);

        }
        int min = byteField.get(byteArrayList.get(0));
        //byte savedKey;
        for (byte b : byteArrayList) {
            //if byteField.;
            if (min > byteField.get(b)) {
                min = byteField.get(b);
                //      savedKey = b;
            }
        }
        for (Map.Entry<Byte, Integer> entry : byteField.entrySet()) {
            int i = entry.getValue();
            if (i == min) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }catch (IndexOutOfBoundsException | FileNotFoundException e){e.printStackTrace();}

    reader.close();
    fileInputStream.close();}
    }


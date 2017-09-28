package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
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
        byte savedKey;
        for (byte b : byteArrayList){
            //if byteField.;
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
        reader.close();
        fileInputStream.close();
    }
}


package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        /*
            -u id productName price quantity
            -d id*/

        if(args[0].equals("-u"))updateItem(args[1],args[2],args[3],args[4],fileName);
        if(args[0].equals("-d"))removeItem(args[1], fileName);

    }

    private static void updateItem(String id,String productName,String price, String quantity,String fileName)
    throws IOException
    {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader bufferedFileReader = new BufferedReader( new InputStreamReader( new FileInputStream(fileName)));
        String line;
        while ((line = bufferedFileReader.readLine()) != null) {
            if(!line.substring(0,8).trim().equals(id))
                list.add(line);
            else
            list.add(String.format("%-8d%-30s%-8s%-4s", Integer.parseInt(id), productName, price, quantity));
        }
        bufferedFileReader.close();

        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(fileName) ));
        for (String s : list ) {
            writer.write(s);
            writer.write(System.lineSeparator());
        }
        writer.close();

    }
    private static void removeItem(String id,String fileName) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        BufferedReader bufferedFileReader = new BufferedReader( new InputStreamReader( new FileInputStream(fileName)));
        String line;
        while ((line = bufferedFileReader.readLine()) != null) {
            if(!line.substring(0,8).trim().equals(id))
            list.add(line);
        }
        bufferedFileReader.close();

        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(fileName) ));
        for (String s : list ) {
            writer.write(s);
            writer.write(System.lineSeparator());
        }
        writer.close();

    }

}

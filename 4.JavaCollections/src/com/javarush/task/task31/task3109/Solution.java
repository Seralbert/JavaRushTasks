package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        //D:\YandexDisk\JR\JavaRushTasks\4.JavaCollections\src\com\javarush\task\task31\task3109
        //Properties properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.xml");
        Properties properties = solution.getProperties("D:\\YandexDisk\\JR\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.xml");
        properties.list(System.out);

        //properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.txt");
        properties = solution.getProperties("D:\\YandexDisk\\JR\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.txt");
        properties.list(System.out);
/*
        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);*/
    }

    public Properties getProperties(String fileName){
        Properties p = new Properties();
        try {
            FileInputStream in = new FileInputStream(fileName);
            if (fileName.endsWith(".xml")) {
                p.loadFromXML(in);
            } else {
                p.load(in);
            }
            return p;
        } catch (IOException e) {e.printStackTrace();}
        return p;
    }
}

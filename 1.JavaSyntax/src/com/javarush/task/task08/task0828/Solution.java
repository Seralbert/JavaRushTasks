package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Map<String,Integer> mounth = new HashMap<>();
        mounth.put("January",1);
        mounth.put("February",2);
        mounth.put("March",3);
        mounth.put("April",4);
        mounth.put("May",5);
        mounth.put("June",6);
        mounth.put("July",7);
        mounth.put("August",8);
        mounth.put("September",9);
        mounth.put("October",10);
        mounth.put("November",11);
        mounth.put("December",12);

        Scanner reader = new Scanner(System.in);

        String line = reader.next();
        //System.out.println(line);
        for (Map.Entry entry : mounth.entrySet()) {
            if(entry.getKey().equals(line)) System.out.println(entry.getKey()+ " is " + entry.getValue()+ " month");
        }

    }
}

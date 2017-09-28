package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0]; //"Иванов Иван 31 12 1987";
        String line;

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        while (br.ready()) {
            line = br.readLine();
            String name = line.split(" \\d")[0];
            String date = line.split(name + " ")[1];

            Date dDate = new SimpleDateFormat("dd MM yyyy").parse(date);
            PEOPLE.add(new Person(name, dDate));
        }
        br.close();
        //System.out.println(PEOPLE.get(0).getBirthday());
    }
}

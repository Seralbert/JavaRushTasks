package com.javarush.task.task17.task1710;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat formDateIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat formDateOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c":

                    if (args[2].equals("ж")) allPeople.add(Person.createFemale(args[1], formDateIn.parse(args[3])));
                    else if (args[2].equals("м")) allPeople.add(Person.createMale(args[1], formDateIn.parse(args[3])));
                    System.out.println(allPeople.size() - 1);

                break;
            case "-u":
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                if (args[3].equals("м")) allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                else if (args[3].equals("ж")) allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(formDateIn.parse(args[4]));
                break;
            case "-d":
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
                break;
            case "-i":

                    String sex = allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж";
                    System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " "
                            + sex + " "
                            + formDateOut.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));


                break;
        }
    }
}

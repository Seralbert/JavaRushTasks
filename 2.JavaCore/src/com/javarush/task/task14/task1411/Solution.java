package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
User, Looser, Coder and Proger
Строки(ключи) могут быть такими: «user«, «loser«, «coder«, «proger«.
*/

public class Solution implements Person {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        HashSet<String> sKey = new HashSet<>();
        sKey.add("user");
        sKey.add("loser");
        sKey.add("coder");
        sKey.add("proger");
        HashSet<String> sInput = new HashSet<>();


        while (true){
            if(!sKey.contains(key = reader.readLine()))break;
            sInput.add(key);

        }
        //тут цикл по чтению ключей, пункт 1
        for (String s : sInput)
        {
            //создаем объект, пункт 2
            switch (s){
                case "user": person = new User();break;
                case "loser": person = new Loser();break;
                case "coder": person = new Coder();break;
                case "proger": person = new Proger();break;
            }

            doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if(person instanceof User)((User) person).live();
        if(person instanceof Loser)((Loser) person).doNothing();
        if(person instanceof Coder)((Coder) person).coding();
        if(person instanceof Proger)((Proger) person).enjoy();

    }
}

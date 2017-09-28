package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
//import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<String, String>();

        map.put("F1", "N1");
        map.put("F2", "N2");
        map.put("F3", "N1");
        map.put("F4", "N1");
        map.put("F5", "N2");
        map.put("F6", "N3");
        map.put("F7", "N1");
        map.put("F8", "N2");
        map.put("F9", "N3");
        map.put("F0", "N4");
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        //return map.containsValue(name) ? 1 : 0;
        int i =0;
        for (Map.Entry<String,String> pair : map.entrySet())
        {
            if (name.equals(pair.getValue()))i++;
        }
        //
        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //напишите тут ваш код
        //return map.containsKey(familiya) ? 1 : 0;
        int i = 0;
        for (Map.Entry<String,String> pair : map.entrySet()){
            if(familiya.equals(pair.getKey()))i++;
        }
        return i;
    }

    public static void main(String[] args)
    {
        System.out.println(getCountTheSameFirstName(createMap(),"N1"));

    }

}

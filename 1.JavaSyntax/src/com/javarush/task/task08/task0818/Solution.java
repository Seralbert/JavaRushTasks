package com.javarush.task.task08.task0818;

import java.util.*;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
Удалить из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> siMap = new HashMap<>();

        siMap.put("f1",100);
        siMap.put("f2",200);
        siMap.put("f3",300);
        siMap.put("f4",400);
        siMap.put("f5",500);
        siMap.put("f6",600);
        siMap.put("f7",700);
        siMap.put("f8",800);
        siMap.put("f9",900);
        siMap.put("f10",1000);

        return siMap;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Set<String> tmp = new HashSet<>();

        for (Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue()< 500) tmp.add(entry.getKey());
        }
        map.keySet().removeAll(tmp);
        /*for(Map.Entry<String,Integer> en : map.entrySet()){
            System.out.println(en.getKey());
        }*/
    }

    public static void main(String[] args) {
        //removeItemFromMap(createMap());
    }
}
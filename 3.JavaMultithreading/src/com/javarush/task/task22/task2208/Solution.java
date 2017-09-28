package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> chk = new HashMap<>();
        chk.put("name", "Иванов");
        chk.put("field", "");
        chk.put("age", "10");
        System.out.println(getQuery(chk));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String,String> entry : params.entrySet()){
            if(entry.getValue()!=null){
                if(stringBuilder.length()>0)stringBuilder.append(" and ");
                stringBuilder.append(entry.getKey() + " = '" + entry.getValue()+ "'");
            }
        }

        return stringBuilder.toString();
    }
}

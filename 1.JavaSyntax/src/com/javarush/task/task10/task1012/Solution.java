package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита). Вывести результат на экран.
 for (int j = 0; j < alphabet.size(); j++)
            {
a=(list.get(0) + "\0").split(String.valueOf(abcArray[j])).length - 1; c[j]=a;
                a=(list.get(1) + "\0").split(String.valueOf(abcArray[j])).length - 1; c[j]=c[j]+a;
                a=(list.get(2) + "\0").split(String.valueOf(abcArray[j])).length - 1; c[j]=c[j]+a;
                a=(list.get(3) + "\0").split(String.valueOf(abcArray[j])).length - 1; c[j]=c[j]+a;
                a=(list.get(4) + "\0").split(String.valueOf(abcArray[j])).length - 1; c[j]=c[j]+a;
                a=(list.get(5) + "\0").split(String.valueOf(abcArray[j])).length - 1; c[j]=c[j]+a;
                a=(list.get(6) + "\0").split(String.valueOf(abcArray[j])).length - 1; c[j]=c[j]+a;
                a=(list.get(7) + "\0").split(String.valueOf(abcArray[j])).length - 1; c[j]=c[j]+a;
                a=(list.get(8) + "\0").split(String.valueOf(abcArray[j])).length - 1; c[j]=c[j]+a;
                a=(list.get(9) + "\0").split(String.valueOf(abcArray[j])).length - 1; c[j]=c[j]+a;
            }
for (int i = 0; i < 33; i++)
                System.out.println(alphabet.get(i)+" "+c[i]);

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код


        LinkedHashMap<Character,Integer> mField;
        mField = new LinkedHashMap<>();

        for (Character c : alphabet){
            mField.put(c,0);
        }
        for (String s : list){
            char[] mChar = s.toCharArray();
            for (char mc : mChar){
                if(alphabet.contains(mc)){
                    int a = mField.get(mc);
                    mField.replace(mc,a, a+1);}
            }

        }

        /*for (Map.Entry<Character,Integer> entry : mField.entrySet()){
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }*/
        for (char cArr : abcArray){
            System.out.println(cArr + " " + mField.get(cArr));
        }
    }

}

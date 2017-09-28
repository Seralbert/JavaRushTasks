package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
Массив списков строк
Создать массив, элементами которого будут списки строк.
Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] arrayLists = new ArrayList[2];
        arrayLists[0] = new ArrayList<>();
        arrayLists[1] = new ArrayList<>();
        arrayLists[0].add("ArrayList0_0");
        arrayLists[0].add("ArrayList0_1");
        arrayLists[1].add("ArrayList1_0");
        arrayLists[1].add("ArrayList1_1");
        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
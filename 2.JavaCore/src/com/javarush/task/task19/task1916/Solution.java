package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
V 1. Класс SolutionMy должен содержать класс LineItem.
V 2. Класс SolutionMy должен содержать enum Type.
V 3. Класс SolutionMy должен содержать публичное статическое поле lines типа List, которое сразу проинициализировано.
V 4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
V 5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.

*/

/*
*
*
* public static void doSearch(List list1, List list2) {

        if (list1.size() == 0 && list2.size() == 0)
            return;

        String s1 = list1.size() == 0 ? null : list1.get(0);
        String s2 = list2.size() == 0 ? null : list2.get(0);

        int i1 = list1.indexOf(s2);
        int i2 = list2.indexOf(s1);

        if (i1 == i2 && i1 == 0) {
            lines.add(new LineItem(Type.SAME, s1));
            list1.remove(0);
            list2.remove(0);

...

       doSearch(list1, list2);

    }
*
*
* */

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();

        FileReader fr = new FileReader(file1);
        BufferedReader br = new BufferedReader(fr);

        while (br.ready()){
            arrayList1.add(br.readLine());
        }

        br.close();

        fr = new FileReader(file2);
        br = new BufferedReader(fr);

        while (br.ready()){
            arrayList2.add(br.readLine());
        }

        br.close();

        while(arrayList1.size()>0 && arrayList2.size()>0){
            if(arrayList1.get(0).equals(arrayList2.get(0))){
                lines.add(new LineItem(Type.SAME,arrayList1.get(0)));
                arrayList1.remove(0);arrayList2.remove(0);
            } else if(arrayList1.get(0).equals(arrayList2.get(1))){
                lines.add(new LineItem(Type.ADDED,arrayList2.get(0)));
                arrayList2.remove(0);
            } else {
                lines.add(new LineItem(Type.REMOVED,arrayList1.get(0)));
                arrayList1.remove(0);
            }
        }
        if (arrayList1.size() == 1) {
            lines.add(new LineItem(Type.REMOVED, arrayList1.get(0)));
            arrayList1.remove(0);
        } else if (arrayList2.size() == 1) {
            lines.add(new LineItem(Type.ADDED, arrayList2.get(0)));
            arrayList2.remove(0);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

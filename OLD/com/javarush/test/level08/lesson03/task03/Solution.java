package com.javarush.test.level08.lesson03.task03;

import java.util.HashMap;
import java.util.Map;

/* Коллекция HashMap из котов
Есть класс Cat с полем имя (name, String).
Создать коллекцию HashMap<String, Cat>.
Добавить в коллекцию 10 котов, в качестве ключа использовать имя кота.
Вывести результат на экран, каждый элемент с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String[] cats = new String[] {"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        HashMap<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static HashMap<String, Cat> addCatsToMap(String[] cats)
    {
        //напишите тут ваш код

        /*
        HashMap<String, Cat> map = new HashMap<String, Cat>();
        map.put(cats[0], new Cat(cats[0]));
        map.put(cats[1], new Cat(cats[1]));
        map.put(cats[2], new Cat(cats[2]));
        map.put(cats[3], new Cat(cats[3]));
        map.put(cats[4], new Cat(cats[4]));
        map.put(cats[5], new Cat(cats[5]));
        map.put(cats[6], new Cat(cats[6]));
        map.put(cats[7], new Cat(cats[7]));
        map.put(cats[8], new Cat(cats[8]));
        map.put(cats[9], new Cat(cats[9]));
        return map;
         */
        HashMap<String, Cat> arr = new HashMap<String, Cat>();

        for(String str : cats)
        {
            arr.put(str, new Cat(str));
        }

        return arr;

    }


    public static class Cat
    {
        String name;

        public Cat(String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            return name != null ? name.toUpperCase() : null;
        }
    }
}

package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст, жень-шень - корень,
 земляника - ягода, ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/

import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Map<String,String> smap = new HashMap<String, String>();
        smap.put("арбуз", "ягода");
        smap.put("банан", "трава");
        smap.put("вишня", "ягода");
        smap.put("груша", "фрукт");
        smap.put("дыня", "овощ");
        smap.put("ежевика", "куст");
        smap.put("жень-шень", "корень");
        smap.put("земляника", "ягода");
        smap.put("ирис", "цветок");
        smap.put("картофель", "клубень");

        /*Iterator<Map.Entry<String, String>> iterator = smap.entrySet().iterator();




        while (iterator.hasNext())

        {
            //получение «пары» элементов
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();            //ключ
            String value = pair.getValue();        //значение
            System.out.println(key + " - " + value);
        }
        */
        for(Map.Entry<String, String> pair : smap.entrySet())
        {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

    }
}

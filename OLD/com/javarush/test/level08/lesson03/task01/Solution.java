package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Set<String> arr = new HashSet<String>();

        arr.add("арбуз");
        arr.add("банан");
        arr.add("вишня");
        arr.add("груша");
        arr.add("дыня");
        arr.add("ежевика");
        arr.add("жень-шень");
        arr.add("земляника");
        arr.add("ирис");
        arr.add("картофель");

        for(String l : arr)
        {
            System.out.println(l);
        }
    }
}

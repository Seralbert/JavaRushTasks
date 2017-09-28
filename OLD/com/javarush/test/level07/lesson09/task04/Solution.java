package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2
        list.add(bis.readLine());
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list)
    {

        ArrayList<String> list1 = new ArrayList<String>();
        Iterator<String> it = list.iterator();

        while (it.hasNext())
        {
            String s = it.next();
            int r_count = 0, l_count = 0;


            for (char c : s.toCharArray())
            {
                if (c == 'р') r_count++;
                if (c == 'л') l_count++;
            }
            if (r_count > 1 & l_count > 1)
            {
                //rl_count = 1;
                r_count = 0;
                l_count = 0;
            }

            //if(r_count > 0){}
            if (l_count > 0 && r_count > 0) list1.add(s);
            if (l_count > 0 && r_count == 0)
            {
                list1.add(s);
                list1.add(s);
            }
            //if(rl_count > 0){}
            if (l_count == 0 && r_count == 0) list1.add(s);


        }


        return list1;
    }


}
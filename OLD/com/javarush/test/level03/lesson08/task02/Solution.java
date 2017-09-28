package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        String snum1 = reader.readLine();
        String snum2 = reader.readLine();

        int inum1 = Integer.parseInt(snum1);
        int inum2 = Integer.parseInt(snum2);

        System.out.print(name + " получает " + inum1 + " через " + inum2 + " лет.");
        //напишите тут ваш код

    }
}
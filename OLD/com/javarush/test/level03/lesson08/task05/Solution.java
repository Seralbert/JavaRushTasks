package com.javarush.test.level03.lesson08.task05;

/* Чистая любовь
Ввести с клавиатуры три имени, вывести на экран надпись:
name1 + name2 + name3 = Чистая любовь, да-да!
Пример: Вася + Ева + Анжелика = Чистая любовь, да-да!
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String n1 = buff.readLine();
        String n2 = buff.readLine();
        String n3 = buff.readLine();

        System.out.print(n1 + " + " + n2 + " + " + n3 + " = Чистая любовь, да-да!");
    }
}
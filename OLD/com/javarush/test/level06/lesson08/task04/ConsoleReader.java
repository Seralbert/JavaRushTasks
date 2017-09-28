package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
boolean readBoolean() – читает с клавиатуры строку "true" или "false" и возвращает соответствующую логическую переменную true или false
Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода
*/

public class ConsoleReader
{
    public static String readString() throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String svar = r.readLine();
        return svar;//напишите тут ваш код

    }

    public static int readInt() throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int ivar = Integer.parseInt(r.readLine());
        return ivar;//напишите тут ваш код

    }

    public static double readDouble() throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        double dvar = Double.parseDouble(r.readLine());//напишите тут ваш код
        return  dvar;
    }

    public static boolean readBoolean() throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));//напишите тут ваш код
        String chpnt;
        for( ;true; ){
            chpnt = r.readLine();
            if(chpnt.equals("true")||chpnt.equals("false"))break;
        }
        if (chpnt.equals("true"))return true;
        else return false;
    }
}

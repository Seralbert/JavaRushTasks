package com.javarush.task.task22.task2201.test;

/**
 * Created by USER-PC on 06.10.2017.
 */
public class Test
{
    static String test1 = "A\tB\tC\tD\tE\tF\tG\tH\tI";
    static String test2= "\t";

    public static void main(String[] args) {
        String string = test1;
        String[] array = string.split("\t");
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < array.length - 1; i++) {
            sb.append("\t");
            sb.append(array[i]);
        }
        System.out.println(sb.toString().substring(1));
        //System.out.println(string.substring(string.indexOf("\t"),string.lastIndexOf("\t")).replaceFirst("\t",""));
    }
}

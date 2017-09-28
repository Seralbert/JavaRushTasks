package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleSteam = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();

        String line = outputStream.toString();
        line = line.replaceAll("\r\n","");
        String[] item = line.split(" ");
        int result = 0;

        switch (item[1]){
            case "+" : result = Integer.parseInt(item[0])+Integer.parseInt(item[2]);break;
            case "-" : result = Integer.parseInt(item[0])-Integer.parseInt(item[2]);break;
            case "*" : result = Integer.parseInt(item[0])*Integer.parseInt(item[2]);break;
        }
       // line +=String.valueOf(result);
        line +=result;
        System.setOut(consoleSteam);
        System.out.println(line);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


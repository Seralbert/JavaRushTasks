package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String source = outputStream.toString();
        //String[] words = source.split("\r\n");
        String[] words = source.split("\n");

        /*String out = "";
        //String context = "\r\nJavaRush — курсы Java онлайн";
        for (int i = 0; i < words.length; i++)
        {
            if(i%2!=0){
                //out += words[i] + "\r\nJavaRush — курсы Java онлайн\r\n";
                out += words[i] + "\r\nJavaRush - курсы Java онлайн\r\n";
            }else out += words[i] + "\r\n";
        }
*/
        System.setOut(console);
        int i = 0;
        for (String word : words)
        {
            System.out.println(word);
            if(i%2!=0) System.out.println("JavaRush - курсы Java онлайн");
            i++;
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

package com.javarush.task.task15.task1525;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<>();
    static {
        try {

            lines = Files.readAllLines(Paths.get(Statics.FILE_NAME), StandardCharsets.UTF_8);
        }catch (IOException e){
            System.out.println(e.toString());
        }
        for(String line: lines){
            System.out.println(line);
        }

        // или еще круче
        // Files.lines(Paths.get(Statics.FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}

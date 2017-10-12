package com.javarush.task.task22.task2207.test;

import com.javarush.task.task22.task2207.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by USER-PC on 09.10.2017.
 */
public class Test {
    public static List<Solution.Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        String testString = "рот тор торт о\n" +
                "о тот тот тот";
        testString = testString.replaceAll("\n", " ");
        String[] tmp = testString.split(" ");
        ArrayList<String> sArray = new ArrayList<>(Arrays.asList(tmp));


    }
}

package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    public static void moveRing(char from, char to, char free, int count) {
        //напишите тут ваш код
        if (count > 0) {
            //сначала все с 1-го на 3-й
            moveRing(from, free, to, count - 1);
            System.out.println("from " + from + " to " + to);
            //потом с 3-го на 2-й
            moveRing(free, to, from, count - 1);
        }
    }
}
package com.javarush.task.task36.task3613;


import java.util.concurrent.SynchronousQueue;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
        //System.out.println(getExpectedClass().getSimpleName()+".class");
    }

    public static Class getExpectedClass() {

        return SynchronousQueue.class;
    }
}
package com.javarush.task.task05.task0515;

/* 
Инициализация объектов
*/

public class Person {
    private String name;
    private char sex;
    private int money;
    private int weight;
    private double size;
/*
    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }

    public void initialize(String name, int money, char sex) {
        this.name = name;
        this.money = money;
        this.sex = sex;
    }
*/
    public void initialize(String name, char sex, int money,int weight, double size){
        this.money = money;
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.size = size;
    }
    public static void main(String[] args) {

    }
}

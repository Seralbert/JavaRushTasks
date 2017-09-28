package com.javarush.task.task05.task0508;

/* 
Геттеры и сеттеры для класса Person
*/

public class Person {
    //напишите тут ваш код
    private String name;
    private int age;
    private char sex;
    private String address;

    public String getName(){return this.name;}
    public int getAge() {return this.age;}
    public char getSex() {return this.sex;}
    public String getAddress() {return this.address;};

    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age  = age;}
    public void setSex(char sex){this.sex = sex;}
    public void setAddress(String address){this.address = address;}


    public static void main(String[] args) {

    }
}

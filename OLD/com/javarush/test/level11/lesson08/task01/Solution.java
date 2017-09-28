package com.javarush.test.level11.lesson08.task01;

/* Все скрыто
Скрыть все внутренние переменные класса Cat.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //test
        Cat mCat = new Cat();
        mCat.setName("Sas");
        mCat.setAge(10);
        mCat.setWeight(10);
    }

    public static  class Cat
    {
        private String name;
        private int age;
        private int weight;

        public Cat()
        {
        }

        Cat(String name, int age, int weight)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setAge(int age){
            this.age = age;
        }
        public void setWeight(int weight){
            this.weight = weight;
        }
    }
}

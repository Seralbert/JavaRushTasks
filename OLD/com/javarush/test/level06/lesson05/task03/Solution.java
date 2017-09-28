package com.javarush.test.level06.lesson05.task03;

/* По 50 000 объектов Cat и Dog
Создать в цикле по 50 000 объектов Cat и Dog. (Java-машина должна начать уничтожать неиспользуемые, и метод finalize хоть раз да вызовется).
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        //ArrayList<Cat> kiti = new ArrayList<Cat>();
        //ArrayList<Dog> doggi = new ArrayList<Dog>();
        for (int i = 0; i < 50000; i++)
        {
            //kiti.add(new Cat());
            //doggi.add(new Dog());

            Cat cat = new Cat();

            Dog dog = new Dog();
        }

    }
}
class Cat
{
    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println("Cat destroyed");
    }
}

class Dog
{
    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println("Dog destroyed");
    }
}
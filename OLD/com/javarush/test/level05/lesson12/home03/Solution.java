package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        //напишите тут ваш код

        Cat TomCat = new Cat("Tom",100,60);
        Dog dog1 = new Dog("Spike", 60, true);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }
    public static class Cat
    {
        String name;
        int tryed, age;

        public Cat(String name, int tryed, int age)
        {
            this.name = name;
            this.tryed = tryed;
            this.age = age;
        }
    }
    public static class Dog
    {
        String name;
        int age;
        boolean sleeped;

        public Dog(String name, int age, boolean sleeped){
            this.name = name;
            this.age = age;
            this.sleeped = sleeped;
        }
    }

    //добавьте тут ваши классы

}

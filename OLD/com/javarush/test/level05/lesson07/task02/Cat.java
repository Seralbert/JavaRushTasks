package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь
 средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null).
  То же касается адреса: null.
*/

public class Cat
{
    private String name = null;
    private int age = 0;
    private int mass = 3;
    private String address = null;
    private String color = null;

    public void initialize(String name)
    {
        this.name = name;
    }

    public void initialize(String name, int mass, int age)
    {
        this.name = name;
        this.mass = mass;
        this.age = age;

    }

    public void initialize(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void initialize(int mass, String color)
    {
        this.mass = mass;
        this.color = color;
    }

    public void initialize(int mass, String color, String address)
    {
        this.address = address;
        this.color = color;
    }
    //напишите тут ваш код

}

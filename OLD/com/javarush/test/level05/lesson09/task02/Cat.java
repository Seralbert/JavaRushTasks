package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес.
 Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{

    //напишите тут ваш код
    private String name = null, color = null, addr = null;
    private int age = 0, mass = 3;

    Cat(String name){
        this.name = name;
    }

    Cat(String name, int mass, int age){
        this.name = name;
        this.age = age;
        this.mass = mass;
    }

    Cat(String name, int age){
        this.name= name;
        this.age = age;

    }

    Cat(int mass, String color){
        this.mass = mass;
        this.color = color;
    }

    Cat(int mass, String color, String addr){
        this.mass = mass;
        this.color = color;
        this.addr = addr;
    }

}

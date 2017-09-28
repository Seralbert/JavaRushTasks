package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. пункт 3
        Iterator<Cat> it = cats.iterator();
        Cat c  = it.next();

        cats.remove(c);

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //напишите тут ваш код. пункт 2
       /* Cat cat1 = new Cat("1");
        Cat cat2 = new Cat("2");
        Cat cat3 = new Cat("3");
*/
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        HashSet<Cat> mSetCat = new HashSet<Cat>();
        mSetCat.add(cat1);
        mSetCat.add(cat2);
        mSetCat.add(cat3);
        return  mSetCat;
        //return null;
    }

    public static void printCats(Set<Cat> cats)
    {

        // пункт 4
       for(Cat c : cats){
            System.out.println(c);
        }
    }

    // пункт 1
    public static class Cat
    {
       /* private String name;
        Cat(String name){
            this.name = name;
        }*/
    }
}

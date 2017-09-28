package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
//напишите тут ваш код
        Human gf1 = new Human("gf1",true,50);
        Human gf2 = new Human("gf2",true,50);

        Human gm1 = new Human("gm1",false,50);
        Human gm2 = new Human("gm2",false,50);

        Human f = new Human("f",true,25);
        Human m = new Human("m",false,25);

        Human ch1 = new Human("ch1",true,1);
        Human ch2 = new Human("ch2",true,2);
        Human ch3 = new Human("ch3",true,3);

        gf1.setCh(f);
        gm1.setCh(f);
        gf2.setCh(m);
        gm2.setCh(m);

        f.setCh(ch1);
        f.setCh(ch2);
        f.setCh(ch3);

        m.setCh(ch1);
        m.setCh(ch2);
        m.setCh(ch3);

        System.out.println(gm1);
        System.out.println(gm2);
        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(f);
        System.out.println(m);
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children = new ArrayList<Human>();

        Human(String name, boolean sex,int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        void setCh(Human ch){
            children.add(ch);
        }
//        void shCH(){
//            for (Human ch : children){
//                System.out.println(ch.toString());
           // }
       // }
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            if (this.children != null)
            {
                int childCount = this.children.size();

                if (childCount > 0)
                {
                    text += ", дети: " + this.children.get(0).name;

                    for (int i = 1; i < childCount; i++)
                    {
                        Human child = this.children.get(i);
                        text += ", " + child.name;
                    }
                }
            }
            return text;
        }
    }

}

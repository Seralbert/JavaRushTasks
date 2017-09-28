package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
Задача:
У каждой кошки есть имя и кошка-мама.
Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму.
Вывести их на экран.

Новая задача:
У каждой кошки есть имя, кошка-папа и кошка-мама.
Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов:
дедушку (папин папа),
бабушку (мамина мама),
папу,
маму,
сына,
дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

*/
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        Cat gf1 = new Cat("GF1");
        Cat gm1 = new Cat("GM1");
        Cat f = new Cat("F");
        Cat m = new Cat("M");
        Cat s = new Cat("S");
        Cat d = new Cat("D");

        f.setFather(gf1.getName());
        m.setMother(gm1.getName());

        s.setMother(m.getName());
        d.setMother(m.getName());

        s.setFather(f.getName());
        d.setFather(f.getName());

        System.out.println(gf1.toString());
        System.out.println(gm1.toString());
        System.out.println(f.toString());
        System.out.println(m.toString());
        System.out.println(s.toString());
        System.out.println(d.toString());

        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother);

        System.out.println(catMother);
        System.out.println(catDaughter);


    }

    public static class Cat {
        private String name;
        //private Cat parent;
        private String mother;
        private String father;
        Cat(String name) {
            this.name = name;
        }
        public void setMother(String  mother){this.mother = mother;}
        public void setFather(String father){this.father = father;}
        public String getName(){return this.name;}

        @Override
        public String toString() {
            String ret = "Cat name is " + name;
            if (mother == null)
                ret = ret + ", no mother ";
            else
                ret = ret + ", mother is " + mother;
            if (father == null)
                ret = ret + ", no father ";
            else
                ret = ret + ", father is " + father;
            return ret;
        }
    }

}
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String grandFatherName = reader.readLine();
        Cat grandFather = new Cat(grandFatherName);
        String grandMotherName = reader.readLine();
        Cat grandMother = new Cat(grandMotherName);
        String fatherName = reader.readLine();
        Cat father = new Cat(fatherName, grandFather, null);
        String motherName = reader.readLine();
        Cat mother = new Cat(motherName, null, grandMother);
        String sonName = reader.readLine();
        Cat son = new Cat(sonName, father, mother);
        String daughterName = reader.readLine();
        Cat daughter = new Cat(daughterName, father, mother);
        System.out.println(grandFather);
        System.out.println(grandMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(daughter);
    }
    public static class Cat
    {
        private String name;
        private Cat mother;
        private Cat father;
        Cat(String name) {
            this.name = name;
        }
        Cat(String name, Cat mother)
        {
            this.name = name;
            this.mother = mother;
        }
        Cat(String name, Cat father, Cat mother)
        {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }
        @Override
        public String toString()
        {
            String string = "";
            string += "Cat name is " + name;
            if (mother == null) string += ", no mother";
            else string +=  ", mother is " + mother.name;
            if (father == null) string += ", no father";
            else string +=  ", father is " + father.name;
            return string ;
        }
    }
}
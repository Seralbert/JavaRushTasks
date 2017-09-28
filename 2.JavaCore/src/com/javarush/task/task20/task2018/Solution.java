package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";

        public A(){}
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        void writeObject(ObjectOutputStream o) throws IOException{
            o.defaultWriteObject();
            //writeObject(o);
            o.writeObject(this.name);
            //o.flush();
        }
        void readObject(ObjectInputStream o) throws IOException, ClassNotFoundException {
            o.defaultReadObject();
            this.name = (String)o.readObject();
            //o.readObject();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2");
        System.out.println(b.name);
        //System.out.println("Start Saving");
        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);
        //System.out.println("Start Reading");
        B b1 = (B)ois.readObject();
        System.out.println(b1.name);
    }
}

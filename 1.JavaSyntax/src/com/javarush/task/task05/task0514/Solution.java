package com.javarush.task.task05.task0514;

/* 
Программист создает человека
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Person person = new Person();
        person.initialize("Name",12);
    }

    static class Person {
        //напишите тут ваш код
        private String name;
        private int age;
       /* private char sex;
        private String address;

        public String getName(){return this.name;}
        public int getAge() {return this.age;}
        public char getSex() {return this.sex;}
        public String getAddress() {return this.address;};

        public void setName(String name){this.name = name;}
        public void setAge(int age){this.age  = age;}
        /*public void setSex(char sex){this.sex = sex;}
        public void setAddress(String address){this.address = address;}
        */
        public void initialize(String name, int age){
          this.name = name;
          this.age = age;
        }
    }
}

package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
        }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String fName;
        private String sName;
        private String lName;
        private boolean married;
        private boolean isDead;
        private int age;


        public Human(String fName){
            this.fName = fName;
        }
        public Human(String fName,boolean married){
            this.fName = fName;
            this.married = married;
        }
        public Human(String fName, boolean married, int age){
            this.fName = fName;
            this.married = married;
            this.age = age;
        }
        public Human(String fName, String lName){
            this.fName = fName;
            this.lName = lName;
        }
        public Human(String fName, String lName, boolean married){
            this.fName = fName;
            this.lName = lName;
            this.married =married;
        }
        public Human(String fName, String lName, boolean married, int age){
            this.fName = fName;
            this.lName = lName;
            this.married = married;
            this.age = age;
        }
        public Human(String fName, String sName, String lName){
            this.fName = fName;
            this.sName = sName;
            this.lName = lName;
        }
        public Human(String fName, String sName, String lName , boolean married){
            this.fName = fName;
            this.sName = sName;
            this.lName = lName;
            this.married = married;
        }
        public Human(String fName, String sName, String lName, boolean married, int age){
            this.fName = fName;
            this.sName = sName;
            this.lName = lName;
            this.married = married;
            this.age = age;
        }
        public Human(String fName, String sName, String lName, boolean married, int age, boolean isDead){
            this.fName = fName;
            this.sName = sName;
            this.lName = lName;
            this.married = married;
            this.age = age;
            this.isDead = isDead;
        }
    }
}

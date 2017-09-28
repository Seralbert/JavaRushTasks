package com.javarush.task.task13.task1305;

/* 
4 ошибки
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        //System.out.println(new Dream().HOBBIE.toString()); //3
        System.out.println(Dream.HOBBIE.toString());
        System.out.println(new Hobbie().toString());

    }

    interface Desire {
    }

    interface Dream {
        //private static Hobbie HOBBIE = new Hobbie(); //1
        Hobbie HOBBIE = new Hobbie();
    }

    //class Hobbie extends Desire implements Dream { //2
    static class Hobbie implements Desire,Dream {

        static int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }

}

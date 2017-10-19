package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object ch = new Character('*');
            System.out.println((Byte)ch);
    }

    public void methodThrowsNullPointerException() {
        int[] array = new int[5];
        array = null;
        System.out.println(array.length);
        /*Object unknownObject = null;

//плохой способ - может вызвать NullPointerException
        if(unknownObject.equals("knownObject")){
            System.err.println("This may result in NullPointerException if unknownObject is null");
        }*/
    }

    public static void main(String[] args) {

    }
}

package com.javarush.task.task17.task1707;


public class IMF {

    private static IMF imf; //1

    public static  IMF getFund() { //3
        //add your code here - добавь код тут
        synchronized (IMF.class){ //4
        if(imf == null)
        imf = new IMF();

        return imf;}
    }

    private IMF() { //2
    }
}

package com.javarush.task.task29.task2909.human;

/**
 * Created by Admin on 18.08.2017.
 *
 */
public class Soldier extends Human{
    public Soldier(String name, int age) {
        super(name, age);
    }

    //private boolean isSoldier;
    public void fight() {
    }
    @Override
    public void live(){
        fight();
    }
}

package com.javarush.task.task12.task1226;

/* 
Fly, Run, Climb для классов Cat, Dog, Tiger, Duck
*/

public class Solution {

    public abstract class Cat implements Run,Climb {
    }

    public abstract class Dog implements Run {
    }

    public abstract class Tiger extends Cat{
    }

    public abstract class Duck implements Fly, Run {
    }
    public interface Fly{
        void fly();
    }
    public interface Climb{
        void climb();
    }
    public interface Run{
        void run();
    }
}

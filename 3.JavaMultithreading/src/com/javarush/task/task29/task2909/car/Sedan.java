package com.javarush.task.task29.task2909.car;

/**
 * Created by Admin on 19.08.2017.
 */
public class Sedan extends Car {
    public final int MAX_SEDAN_SPEED = 120;
   // private int numberOfPassengers;
    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
     //   this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}

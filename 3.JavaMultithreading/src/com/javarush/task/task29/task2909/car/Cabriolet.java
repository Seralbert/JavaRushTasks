package com.javarush.task.task29.task2909.car;

/**
 * Created by Admin on 19.08.2017.
 */
public class Cabriolet extends Car {
    public final int MAX_CABRIOLET_SPEED = 90;
    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
      //  this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}

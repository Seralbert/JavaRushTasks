package com.javarush.task.task29.task2909.car;

/**
 * Created by Admin on 19.08.2017.
 */
public class Truck extends Car {
   // private int numberOfPassengers;
    public final int MAX_TRUCK_SPEED = 80;

    public Truck(int numberOfPassengers) {
        super(Car.TRUCK,numberOfPassengers);

    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}

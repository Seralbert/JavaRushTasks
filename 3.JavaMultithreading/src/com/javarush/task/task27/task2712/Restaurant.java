package com.javarush.task.task27.task2712;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;
import java.util.Locale;

public class Restaurant {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        Cook cook = new Cook("Amigo");
        //Cook cook2 = new Cook("SASA");
        Waiter waiter = new Waiter();
        Tablet tablet = new Tablet(5);
        //Tablet tablet1 = new Tablet(6);
        DirectorTablet directorTablet = new DirectorTablet();
        tablet.addObserver(cook);
        //tablet1.addObserver(cook2);
        cook.addObserver(waiter);
        //cook2.addObserver(waiter);
        tablet.createOrder();
        //tablet1.createOrder();

        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}
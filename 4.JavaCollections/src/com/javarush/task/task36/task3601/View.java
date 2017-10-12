package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by USER-PC on 05.10.2017.
 */
public class View {
    private Controller controler = new Controller();

    public void fireEventShowData() {
        System.out.println(controler.onDataListShow());
    }
}

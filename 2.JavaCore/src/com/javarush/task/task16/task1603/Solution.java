package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread t1 = new SpecialThread();
        SpecialThread t2 = new SpecialThread();
        SpecialThread t3 = new SpecialThread();
        SpecialThread t4 = new SpecialThread();
        SpecialThread t5 = new SpecialThread();
        list.add(new Thread(t1));
        list.add(new Thread(t2));
        list.add(new Thread(t3));
        list.add(new Thread(t4));
        list.add(new Thread(t5));
    }

    public static class SpecialThread  implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}

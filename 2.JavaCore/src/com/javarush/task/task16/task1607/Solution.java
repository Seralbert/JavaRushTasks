package com.javarush.task.task16.task1607;

import java.util.ArrayList;
import java.util.List;

/* 
Horse Racing
*/
/** Еще один, более понятный вариант
 * List notFinished = new ArrayList<>();
 for (Horse horse : horses) {
 if (horse.isFinished())
 countFinished++;
 else {
 System.out.println("Waiting for " + horse.getName());
 notFinished.add(horse);
 }
 }
 for (Horse horse : notFinished) {
 horse.join();
 }
 */

public class Solution {
    public static int countHorses = 10;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart();
        while (calculateHorsesFinished(horses) != countHorses) {
        }
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int countFinished = 0;
        //add your implementation here - добавь свою реалзацию тут

        for (Horse h : horses){
            if(!h.isFinished()){
                h.join();
                System.out.println("Waiting for  "+ h.getName());
            } else { // зачем "инчае" + всегда истинное условие, но без него не проходит
                if (h.isFinished()) ++countFinished;
            }
        }
        return countFinished;
    }

    public static List<Horse> prepareHorsesAndStart() {
        List<Horse> horses = new ArrayList<Horse>(countHorses);
        String number;
        for (int i = 1; i < countHorses + 1; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }

        for (int i = 0; i < countHorses; i++) {
            horses.get(i).start();
        }
        return horses;
    }

    public static class Horse extends Thread {

        private boolean isFinished;

        public Horse(String name) {
            super(name);
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void run() {
            String s = "";
            for (int i = 0; i < 1001; i++) {   //delay
                s += "" + i;
                if (i == 1000) {
                    s = " has finished the race!";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }
}

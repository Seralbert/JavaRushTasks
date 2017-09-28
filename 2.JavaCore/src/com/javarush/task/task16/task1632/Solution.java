package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
static {
    threads.add(new Inf());
    threads.add(new Ex());
    threads.add(new Ura());
    threads.add(new Mess());
    threads.add(new Summ());

    /*for (Thread thread : threads){
        thread.start();
    }*/
    //threads.get(2).start();
}
    public static void main(String[] args) {
    }

    public static class Inf extends Thread {
        public void run(){
            while (true){}
        }
    }

    public static class Ura extends Thread {
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Mess extends Thread implements Message {
        @Override
        public void showWarning() {
            while (!isAlive()){}
        }
        public void run() {}
    }

    public static class Summ extends Thread {
        public void run() {
            int summ = 0;
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                try {
                    line = reader.readLine();
                    if (line.equals("N"))break;
                    if(chk(line))summ += Integer.parseInt(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(summ);

        }
        private boolean chk(String s){
            try {
                Double d = Double.parseDouble(s);
                return true;
            }catch (NumberFormatException e){
            return false;}
        }
    }

    public static class Ex extends Thread {
        public void run(){
            try {
                while (true) Thread.sleep(1000);

            }catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }

}
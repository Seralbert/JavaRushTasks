package com.javarush.task.task25.task2506;

/**
 * Created by Admin on 17.08.2017.
 */
public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        //super.run();
        State baseState = null;
        while (true){
            State current = thread.getState();
            if(baseState!=current) {
                System.out.println(baseState = current);
            }
            if(current.equals(State.TERMINATED))break;
        }
    }
}

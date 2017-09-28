package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true){
            System.out.println(threadName);
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                break;
                //e.printStackTrace();
            }


        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(new TaskManipulator(),threadName);
        thread.start();

    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}

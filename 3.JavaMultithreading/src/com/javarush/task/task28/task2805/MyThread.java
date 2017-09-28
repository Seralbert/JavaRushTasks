package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Zver on 04.09.2017.
 */
public class MyThread extends Thread{
    private ThreadGroup group;
    private String name;
    public static AtomicInteger counter = new AtomicInteger(1);



    private void setPrio(){
        if(counter.get()>10)counter.set(1);
        if(group!=null && counter.get()>group.getMaxPriority())
        {this.setPriority(group.getMaxPriority());
            counter.getAndIncrement();}
         else this.setPriority(counter.getAndIncrement());

    }

    public MyThread() {
        super();

        setPrio();
    }

    public MyThread(Runnable target) {
        super(target);
        setPrio();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.group = group;
        setPrio();
    }

    public MyThread(String name) {
        super(name);
        setPrio();
    }

    public MyThread(ThreadGroup group, String s) {
        super(group,s);
        this.group = group;
        setPrio();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPrio();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.group = group;
        setPrio();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.group = group;
        setPrio();
    }

}

package com.javarush.task.task28.task2807;

import java.util.concurrent.*;

/* 
Знакомство с ThreadPoolExecutor
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here

        /* output example
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < 10; i++) {
            int finalI = i+1;
            queue.add(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(finalI);
                }
            });
        }
        /*
Создай объект ThreadPoolExecutor со следующими параметрами:
— основное количество трэдов (ядро) = 3,
— максимальное количество трэдов = 5,
— время удержания трэда живым после завершения работы = 1000,
— тайм-юнит — миллисекунды,
— созданная в п.1. очередь с задачами.
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,1000,TimeUnit.MILLISECONDS,queue);

        executor.prestartAllCoreThreads();
        executor.shutdown();
        executor.awaitTermination(5,TimeUnit.SECONDS);
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}

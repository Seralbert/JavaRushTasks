package com.javarush.task.task29.task2909.user;

/*
import com.google.common.math.DoubleMath;
import com.google.common.util.concurrent.AtomicDouble;
*/

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);
    {
        userAnya.setMan(false);
        userRoma.setMan(true);
    }



    public void printUsers() {

        userAnya.printInfo();
        userAnya.printAdditionalInfo();
        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }



    public int calculateAverageAge() {
        //int age = 28;
        User userUra = new User("Юра", "Карп", 28);

        //age = (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;

        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        /*base.set(base.get() + age / 100);
        base.set((int) (base.get() * (hasWork ? 1.1 : 0.9)));
        base.set((int) (base.get() * (hasHouse ? 1.1 : 0.9)));*/
        double tmp = base.get();
        tmp += age / 100;
        tmp = tmp*(hasWork?1.1:0.9)*(hasHouse?1.1:0.9);
        return (int) tmp;
    }

    public String getBossName(User user) {
        /*Work work = user.getWork();
        return work.getBoss();*/
        return user.getBoss();
    }
}
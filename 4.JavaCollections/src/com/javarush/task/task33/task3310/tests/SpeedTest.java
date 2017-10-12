package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by USER-PC on 11.10.2017.
 */
public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        long before = new Date().getTime();
        for (String s : strings){
            ids.add(shortener.getId(s));
        }
        long after = new Date().getTime();
        return after-before;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        long before = new Date().getTime();
        for(long id : ids){
            strings.add(shortener.getString(id));
        }
        long after = new Date().getTime();
        return after-before;
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        //Set<Long> ids = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
         origStrings.add(Helper.generateRandomString());
        }


        long timeIdS1 = getTimeForGettingIds(shortener1, origStrings, new HashSet<>());
        long timeIdS2 = getTimeForGettingIds(shortener2, origStrings, new HashSet<>());
        Assert.assertTrue(timeIdS1>timeIdS2);

        //Set<Long> ids = new HashSet<>();
        //long timeStringS1 = getTimeForGettingStrings(shortener1,ids,new HashSet<String>());
        long timeStringS1 = getTimeForGettingStrings(shortener1,new HashSet<Long>(),new HashSet<String>());
        long timeStringS2 = getTimeForGettingStrings(shortener2,new HashSet<Long>(), new HashSet<String>());
        Assert.assertEquals(timeStringS1,timeStringS2,30);

    }
}

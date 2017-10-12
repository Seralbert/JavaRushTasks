package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by USER-PC on 11.10.2017.
 */
public class FunctionalTest {

    public void testStorage(Shortener shortener){
        String s1 = "String";
        String s2 = "Different string";
        String s3 = "String";

        long id1 = shortener.getId(s1);
        long id2 = shortener.getId(s2);
        long id3 = shortener.getId(s3);

        Assert.assertNotEquals(id1,id2);
        Assert.assertNotEquals(id3,s2);

        Assert.assertEquals(id1,id3);

        String receive1 = shortener.getString(id1);
        String receive2 = shortener.getString(id2);
        String receive3 = shortener.getString(id3);

        Assert.assertEquals(receive1,s1);
        Assert.assertEquals(receive2,s2);
        Assert.assertEquals(receive3,s3);
    }
    /*
    Каждый тест должен иметь аннотацию @Test,
    создавать подходящую стратегию,
    создавать объект класса Shortener на базе этой стратегии и вызывать метод testStorage для него.
     */


    @Test
    public void testHashMapStorageStrategy(){
        //testStorage(new Shortener(new HashMapStorageStrategy()));
        HashMapStorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy(){
        //testStorage(new Shortener(new OurHashMapStorageStrategy()));
        OurHashMapStorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy(){
        //testStorage(new Shortener(new FileStorageStrategy()));
        FileStorageStrategy strategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy(){
        //testStorage(new Shortener(new HashBiMapStorageStrategy()));
        HashBiMapStorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy(){
        //testStorage(new Shortener(new DualHashBidiMapStorageStrategy()));
        DualHashBidiMapStorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy(){
        //testStorage(new Shortener(new OurHashBiMapStorageStrategy()));
        OurHashBiMapStorageStrategy strategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
}

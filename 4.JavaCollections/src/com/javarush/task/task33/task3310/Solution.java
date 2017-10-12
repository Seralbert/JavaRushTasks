package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by USER-PC on 09.10.2017.
 */
public class Solution {
    public static void main(String[] args) {
        //Solution solution = new Solution();
        testStrategy(new HashMapStorageStrategy(),10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> set = new HashSet<>();
        for (String s : strings){
            set.add(shortener.getId(s));
        }
        return set;
    }
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> set = new HashSet<>();
        for (long l : keys){
            set.add(shortener.getString(l));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        //Имя стратегии
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> setString = new HashSet<>();
        //Выбор стретегии
        Shortener shortener = new Shortener(strategy);
        //Создание списка строк
        for (int i = 0; i < elementsNumber; i++) {
            setString.add(Helper.generateRandomString());
        }
        //before execution
        // Получение ID шников с замером времни
        long before = new Date().getTime();
        // getId
        Set<Long> setIds = getIds(shortener,setString);
        //after execution
        long after = new Date().getTime();

        Helper.printMessage(Long.toString(after-before));
        // Получение строк с замером времени
        before = new Date().getTime();
        // getStrings
        Set<String> setStrings = getStrings(shortener,setIds);
        //after execution
        after = new Date().getTime();
        Helper.printMessage(Long.toString(after-before));

        //Проверка соответствия

        if(setString.equals(setStrings))Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
        /*if(setString.size() == setStrings.size())Helper.printMessage("Тест пройден");
        else Helper.printMessage("Тест не пройден");*/
    }
}

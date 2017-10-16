package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> nAL = new ArrayList<T>();
        for (Object o : elements){
            nAL.add((T)o);
        }
        return nAL;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {

        //напишите тут ваш код
        HashSet<T> hS = new HashSet<T>();
        for (Object o : elements){
            hS.add((T)o);
        }
        return hS;
    }

    public static <K,V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size())throw new IllegalArgumentException();
        HashMap<K,V> hM = new HashMap<K,V>();
        for (int i = 0; i < keys.size(); i++) {
            hM.put((K)keys.get(i),(V)values.get(i));
        }
        return  hM;
    }
}

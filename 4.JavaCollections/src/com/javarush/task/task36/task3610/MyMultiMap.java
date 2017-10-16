package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        //return map.size();
        return values().size();
    }

    @Override
    public V put(K key, V value) {
    /*
    должен добавить элемент value по ключу key.
    Если в мапе такой ключ уже есть, и количество значений по этому ключу меньше, чем repeatCount — то добавь элемент value в конец листа в объекте map.
    Если по такому ключу количество значений равняется repeatCount — то удали из листа в объекте map элемент с индексом ноль, и добавь в конец листа value.
    Метод должен возвращать значение последнего добавленного элемента по ключу key (но не значение, которое мы сейчас добавляем).
    Если по ключу key значений еще нет — верни null.
    */
        //напишите тут ваш код
        V returnValue = null;
        List<V> listValues = map.get(key);

        if(listValues == null)listValues = new ArrayList<>();
        else {
            returnValue = listValues.get(listValues.size()-1);
            if(repeatCount == listValues.size()) listValues.remove(0);

        }
        listValues.add(value);

        map.put(key,listValues);
        return returnValue;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        /*
        V remove(Object key) — должен удалить элемент по ключу key.
        Если по этому ключу хранится несколько элементов — должен удаляться элемент из листа с индексом ноль.
        Если по какому-то ключу хранится лист размером ноль элементов — удали такую пару ключ : значение.
        Метод должен возвращать элемент, который ты удалил.
        Если в мапе нет ключа key — верни null.
         */
        V returnValue = null;
        List<V> listValues;

            listValues = map.get(key);
            if(listValues == null) return null;
            if(listValues.size()>0){
                returnValue = listValues.get(0);
                listValues.remove(0);
            }
            if(listValues.size() == 0){
                map.remove(key);
            }


        return returnValue;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        /*
        должен вернуть сет всех ключей, которые есть в мапе map
         */
        Set<K> setOfKey = new HashSet<K>();
        for (Map.Entry<K , List<V>> entry :map.entrySet()){
            setOfKey.add(entry.getKey());
        }
        return setOfKey;
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        /*
        должен вернуть ArrayList<V> всех значений. Порядок значений в листе не имеет значения.
         */
        ArrayList<V> listOfValues = new ArrayList<V>();
        for (Map.Entry<K , List<V>> entry :map.entrySet()){
            listOfValues.addAll(entry.getValue());
        }
        return listOfValues;
     }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        /*
        должен вернуть true, если в мапе присутствует ключ key, иначе вернуть false.
         */
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        /*
        должен вернуть true, если в мапе присутствует значение value, иначе вернуть false.
         */
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}
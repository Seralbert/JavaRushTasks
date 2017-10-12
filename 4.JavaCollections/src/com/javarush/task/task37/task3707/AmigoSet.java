package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Zver on 29.09.2017.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;


    public AmigoSet() {
        map = new HashMap<>();
    }
    public AmigoSet(Collection<? extends E> c) {
        map = new HashMap<>(Math.max((int) (c.size() / .75f) + 1, 16));
        addAll(c);
    }
    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }


    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)!=null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    public Object clone(){
        try {
            AmigoSet<E> newAmigoset = (AmigoSet)super.clone();
            newAmigoset.map = (HashMap) map.clone();
            return newAmigoset;
        }catch (Exception e){
            throw new InternalError();
        }

    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        for (E e : map.keySet()){
            out.writeObject(e);
        }
    }
    private void readObject(ObjectInputStream in)throws IOException,ClassNotFoundException{
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        map = new HashMap<E, Object>(capacity,loadFactor);
        for (int i = 0; i < capacity; i++) {
            E e = (E)in.readObject();
            map.put(e,PRESENT);
        }
    }
}

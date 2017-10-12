package com.javarush.task.task33.task3310.strategy;

/**
 * Created by USER-PC on 10.10.2017.
 */
public class OurHashMapStorageStrategy  implements StorageStrategy{
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;
    int hash(Long k){
        /*
        form 1.7
        static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
        1.8:
         */
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }
    int indexFor(int hash, int length){
    /*
    1.8 - method not present
     */
    return hash & (length-1);
    }

    Entry getEntry(Long key){
        int hash = (key == null) ? 0 : hash((long)key.hashCode());
        for (Entry e = table[indexFor(hash,table.length)];
                e != null;
                e = e.next
                ){
            Long k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == 1 << 30) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }


    void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }
    void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key)!=null;
    }

    @Override
    public boolean containsValue(String value) {
        Entry[] tab = table;
        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i] ; e != null ; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;
    }

   @Override
    public void put(Long key, String value) {
       int hash = hash((long)key.hashCode());
       int i = indexFor(hash, table.length);
       for (Entry e = table[i]; e != null; e = e.next) {
           Long k;
           if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
               String oldValue = e.value;
               e.value = value;
               //return oldValue;
           }
       }

       size++;
       addEntry(hash, key, value, i);
       //return null;
    }


    @Override
    public Long getKey(String value) {
        //if(value == null) return 0L;
        for(Entry e : table){
            if (e != null)
            if(e.getValue().equals(value))return e.getKey();
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key).getValue();
    }
}

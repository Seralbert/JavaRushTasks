package com.javarush.task.task33.task3310.strategy;

/**
 * Created by USER-PC on 11.10.2017.
 *
 */

public class FileStorageStrategy implements StorageStrategy {

    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000L;
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public FileStorageStrategy() {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    int hash(Long k){
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }
    int indexFor(int hash, int length){
        return hash & (length-1);
    }

    Entry getEntry(Long key){
        //if(size == 0)return null;
        int hash = (key == null) ? 0 : hash((long)key.hashCode());
        //FileBucket fileBucket = table[indexFor(hash, table.length)];
        for (Entry e = table[indexFor(hash,table.length)].getEntry();
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
        /*
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
         */
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;
        for (FileBucket fileBucket : table){
            /*
            if (fb == null)
            continue;
             */
            Entry entry = fileBucket.getEntry();

            while(entry != null){
                Entry next = entry.next;
                int index = indexFor(entry.hash,newCapacity);
                if(newTable[index]==null){
                    newTable[index] = new FileBucket();
                }
                entry.next = newTable[index].getEntry();
                newTable[index] = new FileBucket();
                newTable[index].putEntry(entry);
                entry = next;
            }
            fileBucket.remove();
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex){
        if(table[bucketIndex].getFileSize()>bucketSizeLimit){
            resize(2 * table.length);
            hash = hash(key);
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash,key,value,bucketIndex);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
    }



    @Override
    public boolean containsKey(Long key) {
        return getEntry(key)!=null;
    }

    @Override
    public boolean containsValue(String value) {
        return getKey(value)!=null;
    }

    @Override
    public void put(Long key, String value) {
        int hash = key != null ? hash(key) : 0;
        int i = indexFor(hash, table.length);
        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for(FileBucket fileBucket : table){
            for (Entry entry = fileBucket.getEntry();
                    entry!=null;
                    entry = entry.next
                    ){
                if(entry.getValue().equals(value))return entry.getKey();
            }
            //if(fileBucket.getEntry().getValue().equals(value))return fileBucket.getEntry().getKey();
        }

        return null;
    }

    @Override
    public String getValue(Long key) {
        if(key == null) return null;
        Entry e = getEntry(key);
        return e != null? e.getValue():null;
    }
}
package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Created by USER-PC on 14.10.2017.
 */
public class CachingProxyRetriever implements Retriever {
    private Storage storage;
    //1, 2
    private LRUCache cache;
    private OriginalRetriever originalRetriever;
    //3

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        this.originalRetriever = new OriginalRetriever(storage);
        cache = new LRUCache(100);
    }

    @Override
    public Object retrieve(long id) {
     //4 5 6
        Object obj = cache.find(id);
        if(obj==null){
            obj = originalRetriever.retrieve(id);
            cache.set(id,obj);
        }
     //7
        return obj;
    }
}

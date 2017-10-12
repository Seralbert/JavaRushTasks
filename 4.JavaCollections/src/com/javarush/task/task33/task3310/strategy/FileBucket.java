package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by USER-PC on 11.10.2017.
 *
 */
public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null,null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }

    }
    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        return 0;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public void putEntry(Entry entry){
        try(
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))
        ){
          objectOutputStream.writeObject(entry);

        }catch (IOException e){
            ExceptionHandler.log(e);
        }
    }
    public Entry getEntry(){
        Entry entry = null;
        if(getFileSize()!=0)
        {
            try(ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))){
                entry = (Entry) objectInputStream.readObject();
            }catch (IOException | ClassNotFoundException e){
                ExceptionHandler.log(e);
            }

        }
        return entry;
    }
}

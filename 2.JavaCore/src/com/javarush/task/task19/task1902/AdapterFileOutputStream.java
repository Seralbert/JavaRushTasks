package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream fileOutputStream;

    AdapterFileOutputStream(FileOutputStream obj){
        this.fileOutputStream = obj;
    }

    public static void main(String[] args) {

    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        byte[] byteString = s.getBytes();
        fileOutputStream.write(byteString);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}


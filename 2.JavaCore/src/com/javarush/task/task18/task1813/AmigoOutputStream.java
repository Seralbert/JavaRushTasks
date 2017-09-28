package com.javarush.task.task18.task1813;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream original) throws FileNotFoundException {
        super(fileName);
        this.original = original;
    }
    @Override
    public void flush() throws IOException {
        this.original.flush();
    }

    @Override
    public void write(int b) throws IOException {
        this.original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.original.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        String cr = "JavaRush © All rights reserved.";
        byte[] copyRight = cr.getBytes();
        this.flush();
        this.write(copyRight);
        this.original.close();
    }

    public static String fileName = "C:/tmp/result.txt";

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }



}

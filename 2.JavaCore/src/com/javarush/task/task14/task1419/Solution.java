package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.util.*;
import java.util.concurrent.ExecutionException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        //1
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
          throw new NumberFormatException();

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new StreamCorruptedException();

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ClassCastException();

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayIndexOutOfBoundsException();

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayStoreException();

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalFormatCodePointException(2);

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new UnknownFormatConversionException("KOI-8");

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new FileNotFoundException();

        } catch (Exception e) {
            exceptions.add(e);
        }


}}

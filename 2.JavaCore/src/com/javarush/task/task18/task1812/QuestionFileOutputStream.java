package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream component) {
        this.original = component;
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        reader.close();
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");

        if(answer.equals("Д")){
            this.original.close();
        }
    }
}


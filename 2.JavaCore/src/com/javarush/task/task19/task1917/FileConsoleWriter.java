package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;
    //PrintStream console = System.out;


    public FileConsoleWriter(String fileName){
        try {
            this.fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileConsoleWriter(String fileName, boolean booleanAppend){
        try {
            this.fileWriter = new FileWriter(fileName,booleanAppend);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileConsoleWriter(File file){
        try {
            this.fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileConsoleWriter(File file, boolean booleanAppend){
        try {
            this.fileWriter = new FileWriter(file, booleanAppend);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileConsoleWriter(FileDescriptor fileDescriptor){
        this.fileWriter = new FileWriter(fileDescriptor);
    }

    public void write(char[] cbuf, int off, int len) throws IOException{
        fileWriter.write(cbuf,off,len);
        String s = "";
        /*for (char c : cbuf){
            s += c;
        }*/
        for (int i = off; i < off+len; i++) {
            s+=cbuf[i];
        }
        System.out.print(s);
    }
    public void write(int c)throws IOException{
        fileWriter.write(c);
        System.out.print(c);
    }
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }
    public void write(String str, int off, int len)throws IOException{
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off,off+len));
    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        String s = "";
        for (char c : cbuf){
            s += c;
        }
        System.out.print(s);
    }
    public void close()throws IOException{
        fileWriter.close();
    }

    public static void main(String[] args) {

    }

}

package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }catch (IOException e){e.printStackTrace();}

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends  Thread implements ReadFileInterface {
        private String fileName;
        private String res = "";
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;

        }
        public void run(){
            ArrayList<String> list = new ArrayList<>();
            //Реализация чтения файла и сборки строки
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                while(reader.ready()){
                    list.add(reader.readLine());
                }
                reader.close();


            } catch (IOException e) {e.printStackTrace();}
            for (String s : list){
                res = res + " " + s;
            }
        }

        public String getFileContent() {
            return res;
        }

    }
}

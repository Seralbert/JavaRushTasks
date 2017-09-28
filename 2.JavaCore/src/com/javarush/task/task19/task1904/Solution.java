package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        PersonScannerAdapter(Scanner scanner){
            this.fileScanner = scanner;
        }
        @Override
        public void close() throws IOException{
            this.fileScanner.close();
        }

        @Override
        public Person read() throws IOException{
            String[] arg = (fileScanner.nextLine()).split(" ");
            int y = Integer.parseInt(arg[5]);
            int m = Integer.parseInt(arg[4])-1;
            int d = Integer.parseInt(arg[3]);
            return new Person(arg[1],arg[2],arg[0],new GregorianCalendar(y,m,d).getTime());
        }


    }
}

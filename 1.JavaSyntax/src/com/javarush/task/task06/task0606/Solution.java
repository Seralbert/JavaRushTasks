package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.ArrayList;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceString = reader.readLine();

        ArrayList<Character> cArray = new ArrayList<>();
        for (char c : sourceString.toCharArray()){
            cArray.add(c);
        }

        for (char c : cArray){
            int tmp = Character.digit(c,10);
            if(tmp%2==0)even++;else odd++;
        }

        System.out.println("Even: "+even+" Odd: "+odd);
    }
}

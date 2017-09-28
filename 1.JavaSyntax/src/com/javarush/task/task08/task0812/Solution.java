package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> integerArrayList = new ArrayList<>(10);
        Scanner reader = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            integerArrayList.add(reader.nextInt());
        }

        int chkValue = integerArrayList.get(0);
        int longuestQuerry = 1;
        int querry = 1;

        for (int i = 1; i < 10; i++) {
            if(integerArrayList.get(i)==chkValue){
                querry++;
                if(querry>longuestQuerry)longuestQuerry=querry;
            }
            else {
                chkValue=integerArrayList.get(i);
                querry = 1;
            }
        }
        System.out.println(longuestQuerry);
    }

}

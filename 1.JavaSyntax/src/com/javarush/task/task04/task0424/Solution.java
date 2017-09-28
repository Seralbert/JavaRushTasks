package com.javarush.task.task04.task0424;

/* 
Три числа
Ввод с клавиатуры, сравнение чисел и вывод на экран — у студентов 4 уровня
секретного центра JavaRush эти навыки оттачиваются до автоматизма.
Давайте напишем программу, в которой пользователь вводит три числа с клавиатуры. V
Затем происходит сравнение, и если мы находим число, которое отличается от двух других,
выводим на экран его порядковый номер.
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(reader.readLine());
        int i2 = Integer.parseInt(reader.readLine());
        int i3 = Integer.parseInt(reader.readLine());
        int pos = 0;
        boolean chk = true;
        if (i1 == i2 & i2 == i3 & i1 == i3)chk = false;
        if (i1 != i2 & i2 != i3 & i1!=i3)chk = false;
        if(chk){
            if (i1 != i2 && i1 != i3) pos = 1;
            if (i2 != i1 && i2 != i3) pos = 2;
            if (i3 != i2 && i3 != i1) pos = 3;
            System.out.println(pos);
        }

    }
}

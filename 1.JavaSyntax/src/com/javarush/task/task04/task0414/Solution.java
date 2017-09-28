package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner reader = new Scanner(System.in);
        int ageChk = reader.nextInt();
        //System.out.println(chk(ageChk));
        if(chk(ageChk)) System.out.println("количество дней в году: 366"); else System.out.println("количество дней в году: 365");


    }
    public static boolean chk(int ageChk){
        boolean id = false;

        if(ageChk%4==0) {
            id = true;// & ageChk%400==0 & ageChk%100!=0)id = true;
        }
        if(ageChk>400)
            if(ageChk%100==0 & ageChk%400!=0)id = false;
        return id;
    }
    /*
* В високосном году — 366 дней, тогда как в обычном — 365.
V Високосным годом является каждый четвёртый год, за исключением столетий, которые не кратны 400.
Так, годы 1700, 1800 и 1900 не являются високосными, так как они кратны 100 и не кратны 400.
Годы 1600 и 2000 — високосные, так как они кратны 100 и кратны 400.
Годы 2100, 2200 и 2300 — не високосные.*/

}
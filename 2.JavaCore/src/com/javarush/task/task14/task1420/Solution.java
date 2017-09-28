package com.javarush.task.task14.task1420;

/* 
НОД
i1 и i2 положительные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int i1 = Integer.parseInt(reader.readLine());
            if (i1<=0)throw new Exception();
            int i2 = Integer.parseInt(reader.readLine());
            if (i2 <= 0)throw new Exception();

        int nod;
        // отловить если равны!!
        if (i1!=i2) {
            int min = (i1 < i2) ? i1 : i2;
            int max = (i1 > i2) ? i1 : i2;

            nod = min;
            //System.out.println("НОД инит" + nod);

            while (nod > 0) {
                if (min % nod == 0 && max % nod== 0) break;
                //System.out.println(nod);
                nod--;
            }
        }else nod = i1;

        System.out.println(nod);
        }catch (NumberFormatException e){
            System.out.println("Введено не число");
        }catch (Exception e){
            System.out.println("Скорее всего введено отрицательное число или ноль");
        }*/
/*
* Алгоритм Евклида
* Вариант для целых положительных чисел
*
* */
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
            int a = Integer.parseInt(reader.readLine());
        if (a <= 0) throw new Exception();
            int b = Integer.parseInt(reader.readLine());
        if (b <= 0) throw new Exception();

        nod(a, b);


    }
    public static void nod(int a, int b)
    {
        if (a > b) a = a - b; else b = b - a;
        if (b == 0)
        {
            System.out.println(a);
            return;
        }
        nod(a, b);
    }
}

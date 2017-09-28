package com.javarush.task.task04.task0413;

/* 
День недели
*/

//import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //int numDay = Integer.parseInt(reader.readLine());
        Scanner mScan = new Scanner(System.in);
        try {
            int numDay = mScan.nextInt();

        /*switch (numDay){
            case 1:
                System.out.println("Понедельник");break;
            case 2:
                System.out.println("Вторник");break;
            case 3:
                System.out.println("Среда");break;
            case 4:
                System.out.println("Четверг");break;
            case 5:
                System.out.println("Пятница");break;
            case 6:
                System.out.println("Суббота");break;
            case 7:System.out.println("Воскресенье");break;
            default:
                System.out.println("такого дня недели не существует");break;
        }*/
            //  for (numDay = 0; numDay < 9; numDay++){
            if (numDay >= 1 & numDay <= 7) {
                if (numDay == 1) System.out.println("понедельник");
                if (numDay == 2) System.out.println("вторник");
                if (numDay == 3) System.out.println("среда");
                if (numDay == 4) System.out.println("четверг");
                if (numDay == 5) System.out.println("пятница");
                if (numDay == 6) System.out.println("суббота");
                if (numDay == 7) System.out.println("воскресенье");
            } else System.out.println("такого дня недели не существует");
        }
        catch (InputMismatchException e){
        }
    }

}
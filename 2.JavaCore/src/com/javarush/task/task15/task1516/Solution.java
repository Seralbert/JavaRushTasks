package com.javarush.task.task15.task1516;

/* 
Значения по-умолчанию
intVar типа int
doubleVar типа double
DoubleVar типа Double
booleanVar типа boolean
ObjectVar типа Object
ExceptionVar типа Exception
StringVar типа String

*/

public class Solution {
    /*public static int intVar;
    public static double doubleVar;
    public static Double DoubleVar = 2d;
    public static boolean booleanVar = true;
    public static Object ObjectVar = 0;
    public static Exception ExceptionVar;
    public static String StringVar = "string";
*/
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;


    public static void main(String[] args) {
        System.out.println(new Solution().intVar);
        System.out.println(new Solution().doubleVar);
        System.out.println(new Solution().DoubleVar);
        System.out.println(new Solution().booleanVar);
        System.out.println(new Solution().ObjectVar);
        System.out.println(new Solution().ExceptionVar);
        System.out.println(new Solution().StringVar);
    }
}

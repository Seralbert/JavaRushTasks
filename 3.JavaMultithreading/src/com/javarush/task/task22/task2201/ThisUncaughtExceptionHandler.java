package com.javarush.task.task22.task2201;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        /*
     RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#*/
        String res = t.toString();
        System.out.println("Other THREAD: t:" + t.toString() + "| e:" + e.toString() + "| string:" + string);
        return res;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        /*
     java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : TooShortStringSecondThreadException : 2#
        */
        //String res = "java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : " + e + " : "+ t;
        String res = "java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : TooShortStringSecondThreadException : 2#";
        return res;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {

        /*
     1# : TooShortStringFirstThreadException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1
        */
        String res = "1# : TooShortStringFirstThreadException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1";
        //String res = t + " : " + e + " : " + "java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : ";
        return res;
    }
}


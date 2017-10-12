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

        //return "t: " + t.getName() + " e: "+ e.getClass().getSimpleName()  + " string: " + string;
        return String.format(string,
                e.getClass().getSimpleName(),
                //"java.lang.StringIndexOutOfBoundsException: String index out of range: -1",
                e.getCause(),
                t.getName());
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return String.format(string,
                //"java.lang.StringIndexOutOfBoundsException: String index out of range: -1",
                e.getCause(),
                e.getClass().getSimpleName(),
                t.getName());
        //return "t: " + t + " e: "+ e  + " string: " + string;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return String.format(string,
                t.getName(),
                e.getClass().getSimpleName(),
                e.getCause()
                //"java.lang.StringIndexOutOfBoundsException: String index out of range: -1"
                );
    }
}


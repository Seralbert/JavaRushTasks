package com.javarush.task.task38.task3804;



/**
 * Created by Zver on 18.10.2017.
 */
public class FabricException {

    //public static Exception getException(Enum e) throws Exception {
    public static Throwable getException(Enum e) throws Exception {
        if(e == null) return new IllegalArgumentException();

        //String message = StringUtils.capitalize(e.name().toLowerCase().replaceAll("_", " "));
        String messageTmp = e.name().toLowerCase().replaceAll("_", " ");
        String message = messageTmp.substring(0,1).toUpperCase() + messageTmp.substring(1);

        if (e instanceof ExceptionApplicationMessage)
            return new Exception(message);

        if (e instanceof ExceptionDBMessage)
            return new RuntimeException(message);

        if (e instanceof ExceptionUserMessage)
            return new Error(message);

        return new IllegalArgumentException();
    }
}

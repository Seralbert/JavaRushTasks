package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by USER-PC on 09.10.2017.
 */
public class Helper {
    public static void printMessage(String message){
        System.out.println(message);
    }
    //Пример генерации RandomString

    /*
    class RandomStringGenerator{

    //initialize secure random
    static final SecureRandom secureRandom = new SecureRandom();

    //get next random string
    public String getNextRandomString(){

        //create 130 bits random BigInteger
        BigInteger bInt = new BigInteger(130, secureRandom);

        //return string representation of BigInteger in 32 radix
        return bInt.toString(32);

    }

    }
     */

    public static String generateRandomString(){

        SecureRandom secureRandom = new SecureRandom();
        BigInteger bInt = new BigInteger(130,secureRandom);
        return bInt.toString(32);
    }

}

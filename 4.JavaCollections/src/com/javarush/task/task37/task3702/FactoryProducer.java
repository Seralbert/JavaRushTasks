package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * Created by USER-PC on 05.10.2017.
 */
public class FactoryProducer {
    public static enum HumanFactoryType {
        MALE,
        FEMALE

    }
    public static AbstractFactory getFactory(HumanFactoryType type){
        if(type.equals(HumanFactoryType.MALE))return new MaleFactory();
        else return new FemaleFactory();
    }
}

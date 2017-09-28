package com.javarush.task.task14.task1408;

/**
 * Created by admin on 21.02.2017.
 *
 * Методы должны возвращать строку вида:
 *<getDescription() родительского класса> + <» Моя страна — Sssss. Я несу N яиц в месяц.»>
 *где Sssss — название страны
 *где N — количество яиц в месяц
 */
//import com.javarush.task.task14.task1408.Solution;

public class BelarusianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 1;
    }
    @Override
    public String getDescription() {
        return super.getDescription()+" Моя страна - "+Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
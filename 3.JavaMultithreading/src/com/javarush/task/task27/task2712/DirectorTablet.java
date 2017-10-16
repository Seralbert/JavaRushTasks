package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by USER-PC on 13.10.2017.
 */
public class DirectorTablet {


    /*public void printAdvertisementProfit(){
        long total = 0;
        for(Map.Entry<String,Long> entry : StatisticManager.getInstance().getStat().entrySet()){
            ConsoleHelper.writeMessage(entry.getKey() + " - " + String.format("%.2f",0.01*entry.getValue()));
            //ConsoleHelper.writeMessage(entry.getKey() + " - " + entry.getValue());
            total+=entry.getValue();
        }
        //DecimalFormat df = new DecimalFormat("#0.00");
        ConsoleHelper.writeMessage(String.format("Total - %.2f" , (double)total/100));
    }
    public void printCookWorkloading(){
        for (Map.Entry<String, Map<String,Integer>> dateEntry : StatisticManager.getInstance().getCooksInfo().entrySet()){
            ConsoleHelper.writeMessage(dateEntry.getKey());
            for(Map.Entry<String,Integer> cookEntry : dateEntry.getValue().entrySet()){
                ConsoleHelper.writeMessage(cookEntry.getKey() + " - " + cookEntry.getValue()/60 + " min");
            }
        }
    }*/

    public void printAdvertisementProfit()
    {
        Map<Date, Double> advertisementProfit = StatisticManager.getInstance().getAdvertisementProfit();
        double totalAmount = 0;
        double amount;
        for (Map.Entry<Date, Double> entry : advertisementProfit.entrySet()) {
            amount = entry.getValue();
            ConsoleHelper.writeMessage(String.format("%1$te-%1$tb-%1$tY - %2$.2f", entry.getKey(), amount));
            totalAmount += amount;
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", totalAmount));
    }

    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> map = StatisticManager.getInstance().getStatisticForCooks();

        for (Map.Entry<String, Map<String, Integer>> entry1 : map.entrySet()) {
            System.out.println(entry1.getKey());
            for (Map.Entry<String, Integer> entry2 : entry1.getValue().entrySet()) {
                System.out.println(entry2.getKey() + " - " + entry2.getValue() + " min");
            }
        }
    }


    public void printActiveVideoSet(){}
    public void  printArchivedVideoSet(){}
}

package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by USER-PC on 12.10.2017.
 */
public class StatisticManager {
    private StatisticStorage statisticStorage = new StatisticStorage();
    private static StatisticManager instance = new StatisticManager();
    private Set<Cook> cooks = new HashSet<>();
    public static StatisticManager getInstance() {
        return instance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        if (data != null)
            statisticStorage.put(data);
    }

    /*public Map<String,Long> getStat(){
        Map<String,Long> res = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> inList = statisticStorage.get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

        for (EventDataRow e : inList){
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) e;
            String tmp = simpleDateFormat.format(e.getDate());
            if(res.containsKey(tmp)){
               res.put(tmp,res.get(tmp)+ videoEvent.getAmount());
            }else res.put(tmp,videoEvent.getAmount());
        }
        return res;
    }

    public Map<String, Map<String,Integer>> getCooksInfo(){
        // Дата, Имя повара : время

        Map<String, Map<String,Integer>> res = new TreeMap<>();
        List<EventDataRow> inList = statisticStorage.get(EventType.COOKED_ORDER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        for(EventDataRow e : inList){
            //CookedOrderEventDataRow cookedEvent = (CookedOrderEventDataRow) e;
            String tempData = simpleDateFormat.format(e.getDate());
            String nameCook = ((CookedOrderEventDataRow) e).getCookName();
            if(res.containsKey(tempData)){
                Map<String,Integer> cookWork = res.get(tempData);
                if(cookWork.containsKey(nameCook)){
                    cookWork.put(nameCook,cookWork.get(nameCook)+e.getTime()/60);
                }else cookWork.put(nameCook,e.getTime());
                res.put(tempData,cookWork);
            } else{
                Map<String,Integer> cookWork = new TreeMap<>(Collections.reverseOrder());
                cookWork.put(nameCook,e.getTime());
                res.put(tempData,cookWork);
            }
        }
        return res;
    }*/

    public Map<Date, Double> getAdvertisementProfit() {
        Map<Date, Double> result = new TreeMap<Date, Double>(Collections.reverseOrder());
        List<EventDataRow> eventDataRowList = statisticStorage.get(EventType.SELECTED_VIDEOS);
        double amount;
        Date date;
        Calendar calendar;
        for (EventDataRow eventDataRow : eventDataRowList) {
            VideoSelectedEventDataRow adVideo = (VideoSelectedEventDataRow) eventDataRow;
            amount = adVideo.getAmount()/100.0;
            calendar = Calendar.getInstance();
            calendar.setTime(adVideo.getDate());
            GregorianCalendar gc = new GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            date = gc.getTime();
            if (result.containsKey(date))
                amount += result.get(date);
            result.put(date, amount);
        }
        return result;
    }

    public Map<String, Map<String, Integer>> getStatisticForCooks()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        //Map<EventType, List<EventDataRow>> storageMap = statisticStorage.getDate();
        List<EventDataRow> list = statisticStorage.get(EventType.COOKED_ORDER);

        Map<String, Map<String, Integer>> map = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow event : list)
        {
            CookedOrderEventDataRow cookedOrderEvent = (CookedOrderEventDataRow) event;
            String date = dateFormat.format(cookedOrderEvent.getDate());
            String cookName = cookedOrderEvent.getCookName();
            int cookingTime = cookedOrderEvent.getTime();
            int cookingTimeMin = (cookingTime % 60 == 0) ? (cookingTime / 60) : (cookingTime / 60 + 1);

            if (map.containsKey(date))
            {
                Map<String, Integer> temp = map.get(date);
                if (temp.containsKey(cookName))
                {
                    temp.put(cookName, temp.get(cookName) + cookingTimeMin);
                } else
                {
                    temp.put(cookName, cookingTimeMin);
                }
                map.put(date, temp);
            } else
            {
                Map<String, Integer> temp = new TreeMap<>();
                temp.put(cookName, cookingTimeMin);
                map.put(date, temp);
            }
        }
        return map;
    }



    public void register(Cook cook){
        cooks.add(cook);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<EventType, List<EventDataRow>>();

        private StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }
        private List<EventDataRow> get(EventType e){
            List<EventDataRow> res = new ArrayList<>();
            res.addAll(storage.get(e));
            return res;
        }
        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}
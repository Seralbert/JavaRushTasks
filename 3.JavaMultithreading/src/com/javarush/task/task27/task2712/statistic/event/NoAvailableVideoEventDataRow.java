package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by USER-PC on 12.10.2017.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow{
    private Date currentDate;
    private int totalDuration;

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    public NoAvailableVideoEventDataRow(int totalDuration){
        /*
        totalDuration — время приготовления заказа в секундах
         */
        this.currentDate = new Date();
        this.totalDuration = totalDuration;

    }
}

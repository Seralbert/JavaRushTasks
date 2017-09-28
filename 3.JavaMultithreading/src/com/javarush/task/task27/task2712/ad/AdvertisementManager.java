package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by USER-PC on 25.09.2017.
 */
public class AdvertisementManager {
    final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    public void processVideos(){

        //ConsoleHelper.writeMessage("calling processVideos method");
        List<Advertisement> availableVideo = storage.list();
        if(availableVideo.isEmpty()) throw new NoVideoAvailableException();
        Collections.sort(availableVideo);


    }
}

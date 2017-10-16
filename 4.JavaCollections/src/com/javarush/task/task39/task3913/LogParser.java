package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery{
    /*private List<String> logStrings = new ArrayList<>();
    //private Path logDir;

    public LogParser(Path logDir) {
        // HardCode logList
    *//*    logStrings.add("127.0.0.1\tAmigo\t30.08.2012 16:08:13\tLOGIN\tOK");
        logStrings.add("192.168.100.2\tVasya Pupkin\t30.08.2012 16:08:40\tDONE_TASK 15\tOK");
        logStrings.add("146.34.15.5\tEduard Petrovich Morozko\t13.09.2013 5:04:50\tDOWNLOAD_PLUGIN\tOK");
        logStrings.add("127.0.0.1\tEduard Petrovich Morozko\t11.12.2013 10:11:12\tWRITE_MESSAGE\tFAILED");
        logStrings.add("146.34.15.5\tEduard Petrovich Morozko\t12.12.2013 21:56:30\tWRITE_MESSAGE\tOK");
        logStrings.add("146.34.15.5\tEduard Petrovich Morozko\t03.01.2014 03:45:23\tLOGIN\tOK");
        logStrings.add("192.168.100.2\tVasya Pupkin\t30.01.2014 12:56:22\tSOLVE_TASK 18\tERROR");
        logStrings.add("127.0.0.1\tVasya Pupkin\t14.11.2015 07:08:01\tWRITE_MESSAGE\tOK");
        logStrings.add("192.168.100.2\tVasya Pupkin\t19.03.2016 00:00:00\tSOLVE_TASK 1\tOK");
        logStrings.add("146.34.15.5\tEduard Petrovich Morozko\t05.01.2021 20:22:55\tDONE_TASK 48\tFAILED");
        logStrings.add("127.0.0.1\tVasya Pupkin\t14.10.2021 11:38:21\tLOGIN\tOK");
        logStrings.add("12.12.12.12\tAmigo\t21.10.2021 19:45:25\tSOLVE_TASK 18\tOK");
        logStrings.add("120.120.120.122\tAmigo\t29.2.2028 5:4:7\tSOLVE_TASK 18\tOK");*//*
        // END test

        //this.logDir = logDir;
    }

    private List<String> getCompactList(Date after, Date before) {
        List<String> result = new ArrayList<>();
        for (String s : logStrings) {
            try {
                String[] values = s.split("\\t");
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                Date chk = format.parse(values[2]);
                if (after == null && before == null) {
                    result.add(s);
                } else if (after == null) {
                    if (chk.getTime() <= before.getTime()) {
                        result.add(s);
                    }
                } else if (before == null) {
                    if (chk.getTime() >= after.getTime()) {
                        result.add(s);
                    }
                } else {
                    if (chk.getTime() >= after.getTime() && chk.getTime() <= before.getTime()) {
                        result.add(s);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after,before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before)  {
        Set<String> result = new HashSet<>();
        for(String s : getCompactList(after,before)){
            String[] values = s.split("\\t");
            result.add(values[0]);
            System.out.println(s);
        }
        return result;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> result = new HashSet<>();
        for(String s : getCompactList(after,before)){
            String[] values = s.split("\\t");
            if(values[1].equals(user))result.add(values[0]);
        }
        return result;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> result = new HashSet<>();
        for(String s : getCompactList(after,before)){
            String[] values = s.split("\\t");
            if(values[3].equals(event.toString()))result.add(values[0]);
        }
        return result;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> result = new HashSet<>();
        for(String s : getCompactList(after,before)){
            String[] values = s.split("\\t");
            if(values[4].equals(status.toString()))result.add(values[0]);
        }
        return result;
    }*/
    private Set<Record> setOfLogObjects;
    private List<String> readLogFiles(Path logDir){
        List<String> result = new ArrayList<>();
        if (Files.isDirectory(logDir)) {
            try {
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(logDir);
                for (Path file: directoryStream) {
                    if (file.getFileName().toString().endsWith(".log")) {
                        BufferedReader bufferedReader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            result.add(line);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    // разбор строк в объекты Record
    private Set<Record> parseStringsToRecordObjects(List<String> listOfLogStrings){
        Set<Record> result = new HashSet<>();
        for (String recordString : listOfLogStrings) {
            String[] recordStringArray = recordString.split("\\t");
            Record record = new Record();
            // ip адрес
            record.setIpAddress(recordStringArray[0]);
            // имя пользователя
            record.setUserName(recordStringArray[1]);
            // дата
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
            try {
                Date date = dateFormat.parse(recordStringArray[2]);
                record.setDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // event
            record.setEvent(Event.valueOf(recordStringArray[3].split("\\s")[0])) ;
            // номер задачи
            if (recordStringArray[3].split("\\s").length>1){
                record.setTaskNumber(Integer.parseInt(recordStringArray[3].split("\\s")[1]));
            }
            // status
            record.setStatus(Status.valueOf(recordStringArray[4]));
            // добавление записи в список
            result.add(record);
        }
        return result;
    }
    // конструктор
    public LogParser(Path logDir){
        this.setOfLogObjects = parseStringsToRecordObjects(readLogFiles(logDir));
    }
    // проверка, попадает ли дата в интервал
    private boolean isDateFromInterval(Date current, Date after, Date before){
        boolean result = false;
        if (after == null) after = current;
        if (before == null) before = current;
        if ((current.getTime()>=after.getTime())&&(current.getTime()<=before.getTime())) result = true;
        return result;
    }
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(record.getDate(),after,before)) {
                ipSet.add(record.getIpAddress());
            }
        }
        return ipSet.size();
    }
    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(record.getDate(),after,before)) {
                ipSet.add(record.getIpAddress());
            }
        }
        return ipSet;
    }
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if ((isDateFromInterval(record.getDate(),after,before)) && (user.equals(record.getUserName()))) {
                ipSet.add(record.getIpAddress());
            }
        }
        return ipSet;
    }
    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if ((isDateFromInterval(record.getDate(),after,before)) && (event.equals(record.getEvent()))) {
                ipSet.add(record.getIpAddress());
            }
        }
        return ipSet;
    }
    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if ((isDateFromInterval(record.getDate(),after,before)) && (status.equals(record.getStatus()))) {
                ipSet.add(record.getIpAddress());
            }
        }
        return ipSet;
    }
}
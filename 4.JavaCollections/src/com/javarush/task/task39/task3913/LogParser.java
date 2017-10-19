package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;


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

public class LogParser implements IPQuery,UserQuery,DateQuery,EventQuery, QLQuery {

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

    @Override
    public Set<String> getAllUsers() {
//2.1. Метод getAllUsers() должен возвращать всех пользователей.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            userSet.add(record.getUserName());
        }
        return userSet;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
// 2.2. Метод getNumberOfUsers() должен возвращать количество уникальных пользователей.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before))userSet.add(record.getUserName());
        }
        return userSet.size();
        //return getAllUsers().size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
//2.3. Метод getNumberOfUserEvents() должен возвращать количество событий от определенного пользователя.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getUserName().equals(user)
                    )userSet.add(record.getEvent().name());
        }
        return userSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
//2.4. Метод getUsersForIP() должен возвращать пользователей с определенным IP.
// Несколько пользователей могут использовать один и тот же IP.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getIpAddress().equals(ip)
                    )userSet.add(record.getUserName());
        }
        return userSet;
    }

    public Set<String> getUsersForDate(Date after, Date before){
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                userSet.add(record.getUserName());
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
//2.5. Метод getLoggedUsers() должен возвращать пользователей, которые были залогинены.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getEvent().equals(Event.LOGIN)
                    // && record.getStatus().equals(Status.OK)
                    )userSet.add(record.getUserName());
        }

        return userSet;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
//2.6. Метод getDownloadedPluginUsers() должен возвращать пользователей, которые скачали плагин.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getEvent().equals(Event.DOWNLOAD_PLUGIN) &&
                    record.getStatus().equals(Status.OK)
                    )userSet.add(record.getUserName());
        }
        return userSet;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
//2.7. Метод getWroteMessageUsers() должен возвращать пользователей, которые отправили сообщение.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getEvent().equals(Event.WRITE_MESSAGE) &&
                    record.getStatus().equals(Status.OK)
                    )userSet.add(record.getUserName());
        }
        return userSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
//2.8. Метод getSolvedTaskUsers(Date after, Date before) должен возвращать пользователей, которые решали любую задачу.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getEvent().equals(Event.SOLVE_TASK)
                    )userSet.add(record.getUserName());
        }
        return userSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
//2.9. Метод getSolvedTaskUsers(Date after, Date before, int task) должен возвращать пользователей,
// которые решали задачу с номером task.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getEvent().equals(Event.SOLVE_TASK) &&
                    record.getTaskNumber()== task
                    )userSet.add(record.getUserName());
        }
        return userSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
//2.10. Метод getDoneTaskUsers(Date after, Date before) должен возвращать пользователей, которые решали любую задачу.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getEvent().equals(Event.DONE_TASK)
                    //&& record.getStatus().equals(Status.OK)
                    )userSet.add(record.getUserName());
        }
        return userSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
//2.11. Метод getDoneTaskUsers(Date after, Date before, int task) должен возвращать пользователей,
// которые решали задачу с номером task.
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getEvent().equals(Event.DONE_TASK)
                    //&& record.getStatus().equals(Status.OK)
                    && record.getTaskNumber() == task
                    )userSet.add(record.getUserName());
        }
        return userSet;
    }

    private Set<Date> getAllDate(Date after, Date before){
        Set<Date> dateSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after, before)) {
                dateSet.add(record.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        //3.1. Метод getDatesForUserAndEvent() должен возвращать даты,
        // когда определенный пользователь произвел определенное событие.
        Set<Date> dateSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after, before)){
                if(record.getUserName().equals(user)
                        && record.getEvent().equals(event))dateSet.add(record.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        //3.2. Метод getDatesWhenSomethingFailed() должен возвращать даты,
        // когда любое событие не выполнилось (статус FAILED).
        Set<Date> dateSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after, before)){
                if(record.getStatus().equals(Status.FAILED))dateSet.add(record.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        //3.3. Метод getDatesWhenErrorHappened() должен возвращать даты,
        // когда любое событие закончилось ошибкой (статус ERROR).
        Set<Date> dateSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after, before)){
                if(record.getStatus().equals(Status.ERROR))dateSet.add(record.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        //3.4. Метод getDateWhenUserLoggedFirstTime() должен возвращать дату,
        // когда пользователь залогинился впервые за указанный период. Если такой даты в логах нет — null.
        Set<Date> dateSet = new HashSet<>();

        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after, before)){
                if(record.getUserName().equals(user)
                        && record.getEvent().equals(Event.LOGIN)
                        )dateSet.add(record.getDate());


            }
        }
        if(dateSet.isEmpty()) return null;
        return Collections.min(dateSet);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        //3.5. Метод getDateWhenUserSolvedTask() должен возвращать дату,
        // когда пользователь впервые попытался решить определенную задачу. Если такой даты в логах нет — null.

        Set<Date> dateSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getUserName().equals(user) &&
                    record.getEvent().equals(Event.SOLVE_TASK)
                    //&& record.getStatus().equals(Status.OK)
                    && record.getTaskNumber() == task
                    )dateSet.add(record.getDate());
        }
        if(dateSet.isEmpty()) return null;
        return Collections.min(dateSet);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        // 3.6. Метод getDateWhenUserDoneTask() должен возвращать дату,
        // когда пользователь впервые решил определенную задачу. Если такой даты в логах нет — null.
        Set<Date> dateSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before) &&
                    record.getUserName().equals(user) &&
                    record.getEvent().equals(Event.DONE_TASK)
                    //&& record.getStatus().equals(Status.OK)
                    && record.getTaskNumber() == task
                    )dateSet.add(record.getDate());
        }
        if(dateSet.isEmpty()) return null;
        return Collections.min(dateSet);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        //3.7. Метод getDatesWhenUserWroteMessage() должен возвращать даты, когда пользователь написал сообщение.
        Set<Date> dateSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after, before)){
                if(record.getUserName().equals(user)&& record.getEvent().equals(Event.WRITE_MESSAGE))
                    dateSet.add(record.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        //3.8. Метод getDatesWhenUserDownloadedPlugin() должен возвращать даты, когда пользователь скачал плагин.
        Set<Date> dateSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after, before)){
                if(record.getUserName().equals(user)&& record.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                    dateSet.add(record.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
//4.1. Метод getNumberOfAllEvents() должен возвращать количество событий за указанный период.
        Set<Event> eventSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                eventSet.add(record.getEvent());
            }
        }
        return eventSet.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before)
    {
        //4.2. Метод getAllEvents() должен возвращать все события за указанный период.
        Set<Event> eventSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                eventSet.add(record.getEvent());
            }
        }
        return eventSet;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        //4.3. Метод getEventsForIP() должен возвращать события, которые происходили с указанного IP.
        Set<Event> eventSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getIpAddress().equals(ip))eventSet.add(record.getEvent());
            }
        }
        return eventSet;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        //4.4. Метод getEventsForUser() должен возвращать события, которые инициировал
        //определенный пользователь.
        Set<Event> eventSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getUserName().equals(user))eventSet.add(record.getEvent());
            }
        }
        return eventSet;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        //4.5. Метод getFailedEvents() должен возвращать события, которые не выполнились.
        Set<Event> eventSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getStatus().equals(Status.FAILED))eventSet.add(record.getEvent());
            }
        }
        return eventSet;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        //4.6. Метод getErrorEvents() должен возвращать события, которые завершились ошибкой.
        Set<Event> eventSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getStatus().equals(Status.ERROR))eventSet.add(record.getEvent());
            }
        }
        return eventSet;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        //4.7. Метод getNumberOfAttemptToSolveTask() должен возвращать количество попыток
        //решить определенную задачу.
        int count = 0;
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getEvent().equals(Event.SOLVE_TASK)
                && record.getTaskNumber()==task
                )count++;
            }
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {

        //4.8. Метод getNumberOfSuccessfulAttemptToSolveTask() должен возвращать количество
        //успешных решений определенной задачи.
        int count = 0;
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getEvent().equals(Event.DONE_TASK)
                        && record.getTaskNumber()==task
                        )count++;
            }
        }
        return count;

    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        //4.9. Метод getAllSolvedTasksAndTheirNumber() должен возвращать мапу (номер_задачи :
        //количество_попыток_решить_ее).
        Map<Integer, Integer> result = new HashMap<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getEvent().equals(Event.SOLVE_TASK)){
                    int taskNumber = record.getTaskNumber();
                    int taskCounter = result.getOrDefault(taskNumber,0);
                    result.put(taskNumber,++taskCounter);
                }

            }
        }
        return result;
    }
    private Set<Status> getAllStatus(Date after, Date before){
        Set<Status> statusSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                statusSet.add(record.getStatus());
            }
        }
        return statusSet;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        //4.10. Метод getAllDoneTasksAndTheirNumber() должен возвращать мапу (номер_задачи :
        //сколько_раз_ее_решили).
        Map<Integer, Integer> result = new HashMap<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getEvent().equals(Event.DONE_TASK)){
                    int taskNumber = record.getTaskNumber();
                    int taskCounter = result.getOrDefault(taskNumber,0);
                    result.put(taskNumber,++taskCounter);
                }

            }
        }
        return result;
    }
    public Set<String> getUserForEvent(Event event, Date after,Date before){
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getEvent().equals(event)){
                    userSet.add(record.getUserName());
                }
            }
        }
        return userSet;
    }
    public Set<String> getUserForStatus(Status status, Date after,Date before){
        Set<String> userSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getStatus().equals(status)){
                    userSet.add(record.getUserName());
                }
            }
        }
        return userSet;
    }
    private Set<Date> getDateForIP(String ip, Date after, Date before){
        Set<Date> dataSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getIpAddress().equals(ip)){
                    dataSet.add(record.getDate());
                }
            }
        }
        return dataSet;
    }
    private Set<Date> getDateForUser(String user, Date after, Date before){
        Set<Date> dataSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getUserName().equals(user)){
                    dataSet.add(record.getDate());
                }
            }
        }
        return dataSet;
    }

    private Set<Date> getDateForEvent(Event event, Date after, Date before){
        Set<Date> dateSet = new HashSet<>();
        for (Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getEvent().equals(event)) dateSet.add(record.getDate());
            }
        }
        return dateSet;
    }

    private Set<Date> getDateForStatus(Status status, Date after, Date before){
        Set<Date> dateSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if (isDateFromInterval(record.getDate(),after,before)){
                if(record.getStatus().equals(status))dateSet.add(record.getDate());
            }
        }
        return dateSet;
    }
    private Set<Event> getEventsForStatus(Status status,Date after, Date before){
        Set<Event> eventSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getStatus().equals(status)){
                    eventSet.add(record.getEvent());
                }
            }
        }
        return eventSet;
    }

    private Set<Status> getStatusForIP(String ip, Date after, Date before){
        Set<Status> statusSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getIpAddress().equals(ip))statusSet.add(record.getStatus());
            }
        }
        return statusSet;
    }
    private Set<Status> getStatusForUser(String user, Date after, Date before){
        Set<Status> statusSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getUserName().equals(user))statusSet.add(record.getStatus());
            }
        }
        return statusSet;
    }

    private Set<Status> getStatusForEvent(Event event, Date after,Date before){
        Set<Status> statusSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if(record.getEvent().equals(event)){
                    statusSet.add(record.getStatus());
                }
            }
        }
        return statusSet;
    }
    private Set<String> getIPsForDate(Date date, Date after, Date before){
        Set<String> ipSet = new HashSet<>();
        for(Record record : setOfLogObjects){
            if(isDateFromInterval(record.getDate(),after,before)){
                if (record.getDate().equals(date))ipSet.add(record.getIpAddress());
            }
        }
        return ipSet;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> answere = new HashSet<>();
        Date after = null;
        Date before = null;

        if(!query.contains("\"")) {


            switch (query) {
//2. Вызов метода execute("get ip") класса LogParser должен возвращать множество (Set) содержащее все уникальные IP адреса.
                case "get ip": {
                    answere.addAll(getUniqueIPs(after, before));
                    return answere;
                }
//3. Вызов метода execute("get user") класса LogParser должен возвращать множество (Set) содержащее всех уникальных пользователей.
                case "get user": {
                    answere.addAll(getAllUsers());
                    return answere;
                }
//4. Вызов метода execute("get date") класса LogParser должен возвращать множество (Set) содержащее все уникальные даты.
                case "get date": {

                    answere.addAll(getAllDate(after, before));
                    return answere;
                }
//5. Вызов метода execute("get event") класса LogParser должен возвращать множество (Set) содержащее все уникальные события.

                case "get event": {
                    answere.addAll(getAllEvents(after, before));
                    return answere;
                }
//6. Вызов метода execute("get status") класса LogParser должен возвращать множество (Set) содержащее все уникальные статусы.
                case "get status": {
                    answere.addAll(getAllStatus(after, before));
                    return answere;
                }
            }
        }else{
            String[] values = query.split("\"");
            String value1 = values[1];

            if(query.contains("and date between")){
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy H:mm:ss", Locale.ENGLISH);
                try {
                    after = dateFormat.parse(values[3]); //after
                    before = dateFormat.parse(values[5]); //before
                } catch (ParseException e) {
                    after = null;
                    before = null;
                    e.printStackTrace();
                }
            }

            //1
            if(query.startsWith("get ip for user =")){
                answere.addAll(getIPsForUser(value1,after,before));
                return answere;
            }
            //2
            //@TODO
            if(query.startsWith("get ip for date =")){
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy H:mm:ss", Locale.ENGLISH);
                try {
                    Date date = dateFormat.parse(value1);
                    //answere.addAll(getIPsForDate(date,after,before));
                    if(isDateFromInterval(date,after,before))
                    answere.addAll(getIPsForDate(date,after,before));
                        //answere.addAll(getUniqueIPs(date,date));
                    return answere;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            //3
            //@TODO
            if(query.startsWith("get ip for event =")){
                answere.addAll(getIPsForEvent(Event.valueOf(value1),after,before));
                return answere;
            }
            //4
            //@TODO

            if(query.startsWith("get ip for status =")){
                Status status = Status.valueOf(value1);
                answere.addAll(getIPsForStatus(status,after,before));
                return answere;
            }
            //5
            if(query.startsWith("get user for ip =")){
                answere.addAll(getUsersForIP(value1,after,before));
                return answere;
            }
            //6
            //@TODO
            if(query.startsWith("get user for date =")){
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
                try {
                    Date date = dateFormat.parse(value1);
                    answere.addAll(getUsersForDate(date,date));
                    return answere;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            //7
            if(query.startsWith("get user for event =")){
                Event event = Event.valueOf(value1);
                answere.addAll(getUserForEvent(event,after,before));
                return answere;
            }
            //8
            if(query.startsWith("get user for status =")){
                Status status = Status.valueOf(value1);
                answere.addAll(getUserForStatus(status,after,before));
                return answere;
            }
            //9
            if(query.startsWith("get date for ip =")){
                answere.addAll(getDateForIP(value1,after,before));
                return answere;
            }
            //10
            if(query.startsWith("get date for user =")){
                answere.addAll(getDateForUser(value1,after,before));
                return answere;
            }
           // 11. Вызов метода execute с параметром "get date for event = "[any_event]""
            // должен возвращать множество уникальных дат, за которые произошло событие равно [any_event].
            if(query.startsWith("get date for event =")){

                answere.addAll(getDateForEvent(Event.valueOf(value1),after,before));
                return answere;
            }
           // 12. Вызов метода execute с параметром "get date for status = "[any_status]""
            // должен возвращать множество уникальных дат, за которые произошло любое событие со статусом [any_status].
            if(query.startsWith("get date for status =")){
                answere.addAll(getDateForStatus(Status.valueOf(value1),after,before));
                return answere;
            }
           // 13. Вызов метода execute с параметром "get event for ip = "[any_ip]""
            // должен возвращать множество уникальных событий, которые произошли с IP адреса [any_ip].
            if(query.startsWith("get event for ip =")){
                answere.addAll(getEventsForIP(value1,after,before));
                return answere;
            }
           // 14. Вызов метода execute с параметром "get event for user = "[any_user]""
            // должен возвращать множество уникальных событий, которые произвел пользователь [any_user].
            if(query.startsWith("get event for user =")){
                answere.addAll(getEventsForUser(value1,after,before));
                return answere;
            }

           // 15. Вызов метода execute с параметром "get event for date = "[any_date]""
            // должен возвращать множество уникальных событий, которые произошли во время [any_date].
            if(query.startsWith("get event for date =")){
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
                try {
                    Date date = dateFormat.parse(value1);
                    answere.addAll(getAllEvents(date,date));
                    return answere;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
           // 16. Вызов метода execute с параметром "get event for status = "[any_status]""
            // должен возвращать множество уникальных событий, которые завершены со статусом [any_status].
            if(query.startsWith("get event for status =")){
                answere.addAll(getEventsForStatus(Status.valueOf(value1),after,before));
                return answere;
            }
           // 17. Вызов метода execute с параметром "get status for ip = "[any_ip]""
            // должен возвращать множество уникальных статусов, которые произошли с IP адреса [any_ip].
            if(query.startsWith("get status for ip =")){
                answere.addAll(getStatusForIP(value1,after,before));
                return answere;
            }
           // 18. Вызов метода execute с параметром "get status for user = "[any_user]""
            // должен возвращать множество уникальных статусов, которые произвел пользователь [any_user].
            if(query.startsWith("get status for user =")){
                answere.addAll(getStatusForUser(value1,after,before));
                return answere;
            }
           // 19. Вызов метода execute с параметром "get status for date = "[any_date]""
            // должен возвращать множество уникальных статусов, которые произошли во время [any_date].
            if(query.startsWith("get status for date =")){
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
                try {
                    Date date = dateFormat.parse(value1);
                    answere.addAll(getAllStatus(date,date));
                    return answere;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
           // 20. Вызов метода execute с параметром "get status for event = "[any_event]""
            // должен возвращать множество уникальных статусов, у которых событие равно [any_event].
            if(query.startsWith("get status for event =")){
                answere.addAll(getStatusForEvent(Event.valueOf(value1),after,before));
                return answere;
            }

        }
        return null;
    }
}
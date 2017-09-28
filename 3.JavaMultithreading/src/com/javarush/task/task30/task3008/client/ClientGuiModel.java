package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zver on 29.08.2017.
 */
public class ClientGuiModel {
    private final Set<String> allUserNames = new HashSet<>();
    private String newMessage;

    public Set<String> getAllUserNames() {
        //return allUserNames;
        return Collections.unmodifiableSet(this.allUserNames);
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }
    public void addUser(String newUserName){
        this.allUserNames.add(newUserName);
    }
    public void deleteUser(String UserName){
        this.allUserNames.remove(UserName);
    }

}

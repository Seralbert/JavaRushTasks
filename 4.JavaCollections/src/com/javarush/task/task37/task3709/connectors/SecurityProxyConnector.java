package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

/**
 * Created by USER-PC on 14.10.2017.
 */
public class SecurityProxyConnector implements Connector {

    private String resourceString;
    private SimpleConnector originalConnector;
    private SecurityChecker cheker;

    public SecurityProxyConnector(String resourceString) {
        this.resourceString = resourceString;
        originalConnector = new SimpleConnector(resourceString);
        cheker = new SecurityCheckerImpl();
    }

    @Override
    public void connect() {
        if(cheker.performSecurityCheck()){
            originalConnector.connect();
            System.out.println("Successfully connected to " + resourceString);
        }
    }
}

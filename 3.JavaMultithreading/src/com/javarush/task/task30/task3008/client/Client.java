package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

/**
 * Created by Zver on 23.08.2017.
 *
 */
public class Client {
    private volatile boolean clientConnected = false;
    protected Connection connection;

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера");
        String serverAddress = ConsoleHelper.readString();
        return serverAddress.isEmpty()?"localhost":serverAddress;
    }
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт сервера");
        int serverPort = ConsoleHelper.readInt();
        return serverPort;
    }
    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){

        try {
            Message message = new Message(MessageType.TEXT,text);
            connection.send(message);
        }catch (IOException e){
            ConsoleHelper.writeMessage("Ошибка при отправке или создании сообщения");
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread {
        /*
        * Класс для чтения сообщений от сервера
        */
        public void run(){
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
            try{
            java.net.Socket socket = new java.net.Socket(serverAddress,serverPort);
            Client.this.connection = new Connection(socket);
            clientHandshake();
            clientMainLoop();
            }catch (IOException  | ClassNotFoundException e){
                notifyConnectionStatusChanged(false);
            }

        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            Message message;
            while (true){
                message = connection.receive();
                if(message.getType()==MessageType.NAME_REQUEST){
                    connection.send(new Message(MessageType.USER_NAME,getUserName()));
                } else
                if(message.getType()==MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    break;
                } else throw new IOException("Unexpected MessageType");

            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            Message message;
            while (true) {
                message = connection.receive();
                if (message.getType() == MessageType.TEXT) processIncomingMessage(message.getData());
                else if (message.getType() == MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
                else if (message.getType() == MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
                else throw new IOException("Unexpected MessageType");
            }
        }

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
            //sendTextMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Пользователь " + userName + " присоединился к чату.");
            //sendTextMessage("Пользователь " + userName + " присоединился к чату.");
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Пользователь " + userName + " покинул чат.");
            //sendTextMessage("Пользователь " + userName + " покинул чат.");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                ConsoleHelper.writeMessage("Ошибка в работе");
                return;
            }
        }
        if(clientConnected)ConsoleHelper.writeMessage("Соединение установлено.");
        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        String message;
        while (clientConnected){
            if(!(message = ConsoleHelper.readString()).equals("exit")){
                if(shouldSendTextFromConsole())sendTextMessage(message);
            }else break;
        }
    }


    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

}

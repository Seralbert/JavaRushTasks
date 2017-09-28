package com.javarush.task.task30.task3008;

//import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/**
 * Created by Admin on 20.08.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new java.util.concurrent.ConcurrentHashMap<>();
    private static class Handler extends Thread{
        private Socket socket;
        Handler(Socket s){
                this.socket = s;
            }

        public void run(){
            ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress());

            try (
                    Connection connection = new Connection(socket)
                    ){

                String userName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));

                sendListOfUsers(connection,userName);

                serverMainLoop(connection,userName);

                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
                ConsoleHelper.writeMessage("Соединение с " + socket.getRemoteSocketAddress() + " разорвано");



            }catch (IOException e){
                ConsoleHelper.writeMessage("IO Exception");
            }catch (ClassNotFoundException e){
                ConsoleHelper.writeMessage("Class Not Found");
            }


        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            boolean breakPoint = false;

            while (!breakPoint){

                connection.send(new Message(MessageType.NAME_REQUEST));
                Message userNameMessage = connection.receive();

                if(userNameMessage.getType()==MessageType.USER_NAME){
                    if(!userNameMessage.getData().isEmpty()){
                        if(!connectionMap.containsKey(userNameMessage.getData())){
                            connectionMap.put(userNameMessage.getData(),connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            ConsoleHelper.writeMessage(userNameMessage.getData() + " accepted");
                            breakPoint = true;
                            return userNameMessage.getData();
                        }
                    }

                }
            }


            return null;
        }
        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for(Map.Entry<String, Connection> entry : connectionMap.entrySet()){
                if(!entry.getKey().equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED,entry.getKey())); // передача списка о всех пользователях
                    //entry.getValue().send(new Message(MessageType.USER_ADDED, userName)); // бродкаст всем о новом пользователе
            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{

            while (!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                //if (message.getType().equals(MessageType.TEXT))
                if (message.getType()==(MessageType.TEXT))
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                else ConsoleHelper.writeMessage("Error");
            }
        }


    }



    public static void sendBroadcastMessage(Message message){
        try {
            for (Map.Entry<String,Connection> entry : connectionMap.entrySet()){
                entry.getValue().send(message);
            }
        }catch (IOException e){
            ConsoleHelper.writeMessage("Сообщение не доставлено");
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        //Socket clientSocket;
        try (
                java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
        ){
            ConsoleHelper.writeMessage("Сервер запущен");

            while (true){
                new Handler(serverSocket.accept()).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

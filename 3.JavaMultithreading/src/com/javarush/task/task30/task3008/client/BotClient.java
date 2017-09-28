package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Zver on 29.08.2017.
 */
public class BotClient extends Client {
    public class BotSocketThread extends SocketThread{
        protected SocketThread getSocketThread(){
            return new BotSocketThread();
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            if(message.contains(":")) {
                String userName = message.split(": ")[0];
                String request = message.split(": ")[1];
                String reg = "";
                switch (request) {
                    case "дата": {
                        reg = "d.MM.YYYY";
                        break;
                    }
                    case "день": {
                        reg = "d";
                        break;
                    }
                    case "месяц": {
                        reg = "MMMM";
                        break;
                    }
                    case "год": {
                        reg = "YYYY";
                        break;
                    }
                    case "время": {
                        reg = "H:mm:ss";
                        break;
                    }
                    case "час": {
                        reg = "H";
                        break;
                    }
                    case "минуты": {
                        reg = "m";
                        break;
                    }
                    case "секунды": {
                        reg = "s";
                        break;
                    }

                /*case "дата": {reg = "%td.%tm.%tY" ; break;}
                case "день": {reg = "%te" ; break;}
                case "месяц": {reg = "%tB" ; break;}
                case "год": {reg = "%tY" ; break;}
                case "время": {reg = "%tk:%tM:%tS" ; break;}
                case "час": {reg = "%tk" ; break;}
                case "минуты": {reg = "%tM" ; break;}
                case "секунды": {reg = "%tS" ; break;}*/
                }
                if (reg.length()>0) {
                    SimpleDateFormat outDate = new SimpleDateFormat(reg);

                    String out = "Информация для " + userName + ": " + outDate.format(Calendar.getInstance().getTime());
                    //String out = "Информация для " + userName + ": " + String.format(reg, new Date());
                    //ConsoleHelper.writeMessage(out);
                    sendTextMessage(out);
                }
            }

        }
    }

    protected boolean shouldSendTextFromConsole(){
        return false;
    }

    protected String getUserName(){
        return "date_bot_" + (int)(Math.random()*100);
    }

    protected SocketThread getSocketThread(){
        return new BotSocketThread();
    }



    public static void main(String[] args) {
        new BotClient().run();
    }
}

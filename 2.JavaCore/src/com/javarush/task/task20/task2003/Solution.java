package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties prop = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);


    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        //PrintWriter printWriter = new PrintWriter(outputStream);

        for (Map.Entry<String, String> entry : properties.entrySet()){
            //printWriter.println(entry.getKey() + ":" + entry.getValue());
            prop.put(entry.getKey(),entry.getValue());
        }
        prop.store(outputStream,"");
        //printWriter.flush();
        //printWriter.close();

    }
    /*при выгрузке из файла вы сохраняете все данные в объекте prop.
     А при сохранении, сохраняете из Map. Делайте так же, только в обратном порядке.
      Сохраняйте из Map в prop, а уже потом записывайте prop в поток.
      Тогда вы будете уверены, что в файл записалось все корректно.
       ps: положить х и у в prop - prop.put(x,y);
       записать prop в поток prop.store(new PrintStream(outputStream), "") (кавычки означают наличие комментов)
      */
    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        try(
                InputStreamReader is = new InputStreamReader(inputStream)
                )
        {

            prop.load(is);
            for (Map.Entry<Object, Object> entry:prop.entrySet()){
                properties.put(entry.getKey().toString(),entry.getValue().toString());
            }
            is.close();
        }

    }

    public static void main(String[] args) {

    }
}

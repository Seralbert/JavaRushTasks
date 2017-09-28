package com.javarush.task.task22.task2211;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset win1251 = Charset.forName("Windows-1251");
        try(
        FileReader reader = new FileReader(args[0]);
        FileWriter writer = new FileWriter(args[1]);
        BufferedReader br = new BufferedReader(reader)
        ){

            while (br.ready()){
                byte[] byteArray = br.readLine().getBytes(win1251);
                String out = new String(byteArray,utf8);
                writer.write(out);
            }
        }
    }
}

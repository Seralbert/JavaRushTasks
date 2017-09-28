/*
package com.javarush.task.task18.task1827;

*/
/*
Прайсы
-c productName price quantity

Значения параметров:
где id — 8 символов.
productName — название товара, 30 chars (60 bytes).
price — цена, 8 символов.
quantity — количество, 4 символа.
-c — добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.
*//*




import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();//"f:/test";

        //long lenghtFile;
        boolean isEmpty;
        int stringLenght = 8 + 30 + 8 + 4;
        RandomAccessFile randomAccessFile = null;
        try{
            if(args[0].equals("-c")) {
                randomAccessFile = new RandomAccessFile(fileName, "rw");
                long numLine = 0;

                if (randomAccessFile.length() == 0) isEmpty = true;
                else isEmpty = false;

                if (!isEmpty) {
                    numLine = randomAccessFile.length() / stringLenght; //количество строк в файле
                }

                randomAccessFile.seek((numLine - 1) * stringLenght);
                String lastLine = randomAccessFile.readLine(); // читаем последнюю строку в файле
                randomAccessFile.seek((numLine) * stringLenght);
                String line = getFormattedString(String.valueOf(getLastIndex(lastLine)+1),8)+ getFormattedString(args[1],30)+ getFormattedString(args[2],8)+
                        getFormattedString(args[3],4);

                randomAccessFile.writeBytes("\n");
                randomAccessFile.writeBytes(line);
                randomAccessFile.close();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(randomAccessFile!=null)randomAccessFile.close();
        }


    }


    private static long getLastIndex(String source){
        String compact = getFormattedString(source,8);
        compact = compact.split(" ")[0];
        compact = compact.trim();
        return Long.parseLong(compact);}

    private static String getFormattedString(String sourceString, int sLenght){
        return String.format("%-" + sLenght + "." + sLenght + "s",sourceString);
    }
}
*/
package com.javarush.task.task18.task1827;
import java.io.*;
import java.util.ArrayList;
public class Solution {
    public ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        BufferedReader console = new BufferedReader( new InputStreamReader( System.in));
        String fileDB = console.readLine();
        if (!args[0].equals("-c")) return;

        console.close();
        int id = sol.getMaxID(fileDB) + 1;
        String newProduct = String.format("%-8d%-30s%-8s%-4s", id, args[1], args[2], args[3]);
//------- restoring all existing lines of the file ----------
//        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(fileDB,true), Charset.forName("Cp1251") ));
//        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(fileDB), Charset.forName("Cp1251") ));
        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(fileDB) ));
        for (String s : sol.list ) {
            writer.write(s);
//            writer.newLine();
            writer.write(System.lineSeparator());
        }
// adding new price line to file
        writer.write(newProduct);
        writer.close();


    }
    public int getMaxID(String filename) throws IOException {
//        BufferedReader bufferedFileReader = new BufferedReader( new InputStreamReader( new FileInputStream(filename), Charset.forName("Cp1251")));
        BufferedReader bufferedFileReader = new BufferedReader( new InputStreamReader( new FileInputStream(filename)));
        int maxID = -1;
        String line;
        while ((line = bufferedFileReader.readLine()) != null) {
            list.add(line);
            int currID= Integer.parseInt(line.substring(0,8).trim());
            if (maxID < currID ) maxID = currID;
        }
        bufferedFileReader.close();
        return maxID;
    }

}

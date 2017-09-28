package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {
        String file1 = "",file2 = "";
        try {
            file1 = reader.readLine();
            file2 = reader.readLine();
            reader.close();

        }catch (IOException e){e.printStackTrace();}
        try {
            allLines = Files.readAllLines(Paths.get(file1));
            forRemoveLines = Files.readAllLines(Paths.get(file2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Solution solution = new Solution();
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }


}

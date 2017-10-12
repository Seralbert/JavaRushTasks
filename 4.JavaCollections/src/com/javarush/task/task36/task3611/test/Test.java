package com.javarush.task.task36.task3611.test;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by USER-PC on 08.10.2017.
 */
public class Test {
    public static void main(String[] args) {
     getAllFriendsAndPotentialFriends(7,1);
    }

    public static Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        //напишите тут ваш код
        //@TODO Реализовать поиск
        Set<Integer> out = new TreeSet<>();
        boolean[][] matrix = generateRelationships();

        //System.out.println(matrix[index].length);
        for (int i = 0; i < matrix[index].length; i++) {
            if(matrix[index][i])out.add(index);
            System.out.print(matrix[index][i] + " ");
            if(deep > 1) out.addAll(getAllFriendsAndPotentialFriends(i,deep-1));
        }
        //System.out.println();
        for (int i = index+1; i < matrix.length; i++) {
            if(matrix[index][i])out.add(index);
            if(deep > 1) out.addAll(getAllFriendsAndPotentialFriends(i,deep-1));
            System.out.print(matrix[i][index] + " ");
        }

        return out;
    }

    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true,  true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true,  true, false, true, true},                                        //4
                {true,  false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }

}

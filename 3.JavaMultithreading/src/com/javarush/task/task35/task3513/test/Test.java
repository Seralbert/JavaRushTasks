package com.javarush.task.task35.task3513.test;

import java.util.Arrays;

/**
 * Created by USER-PC on 17.09.2017.
 */
public class Test {
    static int[][] M = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };
    static int[] testInt = {2,2,0,2};
    public static void main(String[] args) {
        priner(M);
        rotate(4);
        priner(M);
        rotate(4);
        priner(M);
    }

    static void rotate(int N) {
        for (int i = 0; i < (N + 1) / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = M[i][j];
                M[i][j] = M[N - 1 - j][i];
                M[N - 1 - j][i] = M[N - 1 - i][N - 1 - j];
                M[N - 1 - i][N - 1 - j] = M[j][N - 1 - i];
                M[j][N - 1 - i] = temp;
            }
        }
    }

    static void priner(int[][] array){
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    static void zeroMover(){
        for (int j = 0; j < testInt.length-1; j++) {
            for (int i = 0; i < testInt.length-1; i++) {
                if(testInt[i]==0 && testInt[i+1]!=0){
                    int tmp = testInt[i];
                    testInt[i] = testInt[i+1];
                    testInt[i+1] = tmp;
                }
        }
        }
    }

    static void splitter(){
        for (int i = 0; i < testInt.length-1; i++) {
            for (int j = 0; j < testInt.length-1; j++) {
                if(testInt[j]==testInt[j+1]){
                    testInt[j]*=2;
                    testInt[j+1]=0;
                    zeroMover();
                }
            }
        }
        //System.out.println(Arrays.toString(testInt));
    }
}

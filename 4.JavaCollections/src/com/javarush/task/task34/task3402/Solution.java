package com.javarush.task.task34.task3402;

import java.math.BigInteger;

/*
Факториал с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1

    }

/* public static BigInteger FactNaiveTuned(int n)
        {
            if (n <= 1)
                return 1;
            BigInteger r1 = 1, r2 = 1, r3 = 1, r4 = 1;
            int i;
            for (i = n; i > 4; i -= 4)
            {
                r1 *= i;
                r2 *= i - 1;
                r3 *= i - 2;
                r4 *= i - 3;
            }
            int mult = i == 4 ? 24 : i == 3 ? 6 : i == 2 ? 2 : 1;
            return (r1*r2)*(r3*r4)*mult;
        }*/

    public int factorial(int n) {
        if (n<0) return 0;
        if(n == 0) return 1;
        int result;
        result = factorial(n - 1) * n;
        return result;
    }
}

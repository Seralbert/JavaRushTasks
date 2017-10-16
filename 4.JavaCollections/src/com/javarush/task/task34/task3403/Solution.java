package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        new Solution().recursion(132);
    }


    public void recursion(int n){
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    n /= i;
                    if (n > 1) {
                        System.out.print(i + " ");
                        recursion(n);
                        return;
                    }
                    else System.out.print(i);
                }
            }
        }
    }

    /*
        Реализация решета Эрастофена
    */
    public static void simlpeNaturalNumbers(int n){

        int[] a = new int[n+1];
        for (int i = 0; i < n + 1; i++)
            a[i] = i;
        for (int p = 2; p < n + 1; p++)
        {
            if (a[p] != 0)
            {
                System.out.println(a[p]);
                for (int j = p*p; j < n + 1; j += p)
                    a[j] = 0;
            }
        }
    }

    
    public void woRecursion(int n) {
        int i = 2;
        while (i <= n)
        {
            if (n % i == 0)
            {
                System.out.print(i);
                n = n / i;
                if (n > 1)
                {
                    System.out.print(" ");
                }
            }
            else
            {
                i++;
            }
        }
    }


}

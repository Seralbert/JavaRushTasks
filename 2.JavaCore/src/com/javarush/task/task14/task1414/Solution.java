package com.javarush.task.task14.task1414;
    /*
    MovieFactory
    */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        String[] sList = {"soapOpera", "cartoon", "thriller"};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Movie> list = new ArrayList<>();
        while(true){
            String key = reader.readLine();
            list.add(MovieFactory.getMovie(key));
            if(!Arrays.asList(sList).contains(key))
                break;
        }
        for(int i = 0; i < list.size()-1; i++)
            System.out.println(list.get(i).getClass().getSimpleName());
        //for (Movie m : list) System.out.println(m.getClass().getSimpleName()); // - так не работает
    }



            /*
    8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
    8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
    8.2 вывести на экран movie.getClass().getSimpleName()
            */



    static class MovieFactory {
        static Movie getMovie(String key) {
            Movie movie = null;

            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();

            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();

            }
            if ("thriller".equals(key)) {
                movie = new Thriller();

            }

            return movie;
        }
    }
    static abstract class Movie {
    }
    static class SoapOpera extends Movie {
    }
    static class Cartoon extends Movie{
    }
    static class Thriller extends Movie{
    }
}
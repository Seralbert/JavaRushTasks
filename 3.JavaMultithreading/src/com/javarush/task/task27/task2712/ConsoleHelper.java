package com.javarush.task.task27.task2712;
import com.javarush.task.task27.task2712.kitchen.Dish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String s){
        System.out.println(s);
    }
    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> allDishes = new ArrayList<>();
        writeMessage("Меню:");
        for (int i = 0; i < Dish.values().length; i++) {
            writeMessage(Dish.values()[i].ordinal() + " - " + Dish.values()[i]);
        }
        writeMessage("Сделайте Ваш заказ. Введите название блюда: (по завершению заказа введите \"exit\")");
        String s = readString();
        List<String> availableDishes = Arrays.asList(Dish.allDishesToString().split(", "));
        while (!s.equals("exit")){
            if (availableDishes.contains(s)){
                allDishes.add(Dish.valueOf(s));
            }
            else {
                writeMessage("Даное блюдо отсутствует в списке.");
            }
            s = readString();
        }
        if (allDishes.isEmpty())
            writeMessage("Ничего не заказано.");
        else
            writeMessage("Заказ сделан. Я сообщу поварам.");
        return allDishes;
    }
}
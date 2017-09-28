package com.javarush.task.task14.task1405;

/* 
Food
1. Реализовать интерфейс Selectable в классе Food. V
2. Метод onSelect() должен выводить на экран фразу «food was selected«. V
3. Подумай, какие методы можно вызвать для переменной food и какие для selectable.
4. В методе foodMethods вызови методы onSelect, eat, если это возможно. V
5. В методе selectableMethods вызови методы onSelect, eat, если это возможно.V
6. Явное приведение типов не использовать.
*/

public class Solution {
    public static void main(String[] args) {
        Food food = new Food();
        Selectable selectable = new Food();
        Food newFood = (Food) selectable;

        foodMethods(food);
        selectableMethods(selectable);
    }

    public static void foodMethods(Food food) {

        //тут добавьте вызов методов для переменной food
        food.onSelect();
        food.eat();
    }

    public static void selectableMethods(Selectable selectable) {
        //тут добавьте вызов методов для переменной selectable
        selectable.onSelect();
        //selectable.eat(); // Класс не Food в качестве параметра


    }

    interface Selectable {
        void onSelect();
    }

    static class Food implements Selectable{
        public void onSelect(){
            System.out.println("food was selected");
        }
        public void eat() {
            System.out.println("food was eaten");
        }
    }
}

package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/


public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Human man0 = new Human("Дед Вася1", true , "50");
        Human woman0 = new Human("Баба Тася1", false , "49");
        Human man1 = new Human("Дед Вася2", true , "50");
        Human woman1 = new Human("Баба Тася2", false , "49");

        Human man2 = new Human("Ваня", true , "25", man0,woman0);
        Human woman2 = new Human("Таня", false , "19", man1,woman1);

        Human child1 = new Human("дочь1", false , "9", man2,woman2);
        Human child2 = new Human("дочь2", false , "9", man2,woman2);
        Human child3 = new Human("дочь3", false , "9", man2,woman2);

        System.out.println(man0.toString());
        System.out.println(man1.toString());
        System.out.println(man2.toString());

        System.out.println(woman0.toString());
        System.out.println(woman1.toString());
        System.out.println(woman2.toString());

        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());



    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private Boolean sex;
        private String age;
        private Human mother;
        private Human father;
        Human(String name, Boolean sex,String age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, Boolean sex,String age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;

        }
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}

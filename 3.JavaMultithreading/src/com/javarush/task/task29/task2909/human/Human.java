package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{


    public class Size{
        public int height;
        public int weight;

        /*public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }*/

        Size(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }

    private static int nextId = 0;
    private int id;
    private Size size;
    private BloodGroup bloodGroup;
    private List<Human> children = new ArrayList<>();

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }


    protected int age;
    protected String name;

    public void addChild(Human h){
        children.add(h);
    }
    public void removeChild(Human h){
        children.remove(h);
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return this.bloodGroup;
    }

    public Human(String name, int age) {
        this.id = nextId;
        this.age = age;
        this.name = name;
        nextId++;
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }
   public String getPosition(){
        return "Человек";
    }
    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }


    public void live() {
    }



    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
        //System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
}
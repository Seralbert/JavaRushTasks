package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    private double averageGrade;
    //private String university;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name,age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void live() {
        learn();
    }

    public int getCourse() {
        return course;
    }

    public void learn() {
    }



    /*public void printData() {
        System.out.println(getPosition() + ": " + name);
    }*/

    public void incAverageGrade(double delta){
        setAverageGrade(getAverageGrade()+delta);
        //averageGrade += delta;
    }
    /*public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }
*/
    /*public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int) value;
            return;
        }
    }*/



    public void setBeginningOfSession(Date beginningOfSession) {
    //public void setBeginningOfSession(int day, int month, int year) {

        this.beginningOfSession = beginningOfSession;
    }

    public void setEndOfSession(Date endOfSession) {
    //public void setEndOfSession(int day, int month, int year) {

        this.endOfSession = endOfSession;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String getPosition(){
        return "Студент";
    }
}
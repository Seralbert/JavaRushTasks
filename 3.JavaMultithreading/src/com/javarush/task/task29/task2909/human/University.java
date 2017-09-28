package com.javarush.task.task29.task2909.human;


import java.util.ArrayList;
import java.util.List;

public class University extends UniversityPerson{
//public class University extends Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private List<Student> students = new ArrayList<>();
    public University(String name, int age) {
         super(name, age);
        /*this.name = name;
        this.age = age;*/
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //List<Student> list = getStudents();
        //TODO:
        Student student = null;
        for (Student s : getStudents()){
            if(s.getAverageGrade()==averageGrade)student = s;
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        List<Student> allStudent = getStudents();
        Student studentWithMaxGrade = allStudent.get(0);
        for (Student s : getStudents()){
            if(s.getAverageGrade()>studentWithMaxGrade.getAverageGrade())studentWithMaxGrade = s;
        }
        return studentWithMaxGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        //double minGrade = 0;
        List<Student> allStudent = getStudents();
        Student studentWithMinGrade = allStudent.get(0);
        for (Student s : allStudent){
            if(s.getAverageGrade()<studentWithMinGrade.getAverageGrade())studentWithMinGrade = s;
        }
        return studentWithMinGrade;
    }
    public void expel(Student student){
        getStudents().remove(student);
    }
}
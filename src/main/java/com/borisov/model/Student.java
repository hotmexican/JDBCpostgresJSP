package com.borisov.model;

import java.util.ArrayList;
import java.util.List;


public class Student {

    private int id;

    private String name;


    private List<Lesson> lessonList;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public void addLessonToStudent(Lesson lesson){
        if(lessonList ==null){
            lessonList = new ArrayList<>();
        }
        lessonList.add(lesson);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

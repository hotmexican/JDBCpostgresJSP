package com.borisov.model;


import java.util.ArrayList;
import java.util.List;


public class Lesson {

   private int id;

    private  String name;

    private List<Student> studentList;

    public Lesson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Lesson() {
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudentToLesson(Student student){
        if(studentList==null){
            studentList = new ArrayList<>();
        }
        studentList.add(student);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.csc340.restapidemo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataBase {
    private List<Student> studentList;


  public StudentDataBase() {
    studentList = new ArrayList<Student>();
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student) {
      if(!this.studentList.contains(student))
        this.studentList.add(student);
    }

    public Student getStudentById(int id){
      for(Student s : this.studentList){
          if (s.getId() == id){
              return s;
          }
      }
      return null;
    }

    public void deleteStudent(int id){
    }
}

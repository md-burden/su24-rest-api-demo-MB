package com.csc340.restapidemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
      if(!studentList.contains(student))
        studentList.add(student);
    }

    public Student getStudentById(int id){
    /*
     * Since the equals methods only checks the ID, we can pass it a new student object
     * with only the ID filled in, and it will return that specific Student if it exists
     */
      int index = studentList.indexOf(new Student(id, "", "",0));
      if(index != -1) {
          return studentList.get(index);
      }
      return null;
    }

    public void deleteStudent(int id){
        studentList.remove(new Student(id, "", "", 0));
    }

    public Student updateStudent(int id, Student student){
      int index = studentList.indexOf(student);
      if(!studentList.contains(student)){
          return null;
      }
      studentList.set(index, student);
      return studentList.get(index);
    }
}

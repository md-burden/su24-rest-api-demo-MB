package com.csc340.restapidemo;

import java.util.List;

interface FileControllerBase {

    void createFile();
    List<Student> addStudent(Student student);
    List<Student> deleteStudent(int id);
    List<Student> getStudents();
    Student updateStudent(int id,Student student);
    Student getStudentById(int id);


}

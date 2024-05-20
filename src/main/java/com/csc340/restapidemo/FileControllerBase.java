package com.csc340.restapidemo;

import java.util.List;

interface FileControllerBase {

    void createFile();
    List<Student> addStudent(Student student);
    void updateStudent();
    List<Student> getStudents();
    Student getStudentById(int id);
    void deleteStudent();

}

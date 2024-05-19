package com.csc340.restapidemo;

interface FileControllerBase {

    // Should create file if one is not already made
    void createFile();

    // Add student to BD
    void addStudent(Student student);

    // Update specified value(s) in file
    void updateStudent();

    // Read values in file
    void getStudents();

    // Delete student from DB
    void deleteStudent();

}

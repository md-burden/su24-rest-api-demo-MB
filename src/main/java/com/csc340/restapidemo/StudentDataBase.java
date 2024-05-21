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

  /**
   * Adds a Student to be stored in the database
   *
   * @param student Student data to add
   */
  public void addStudent(Student student) {
    if (studentList.contains(student)) return;
    studentList.add(student);
  }

  /**
   * Potentially gets a Student by their ID
   *
   * @param id ID for the desired Student
   * @return Returns a found Student, otherwise returns null
   */
  public Student getStudentById(int id) {
    /*
     * Since the equals methods only checks the ID, we can pass it a new student object
     * with only the ID filled in, and it will return that specific Student if it exists
     */
    int index = studentList.indexOf(new Student(id));
    if (index != -1) {
      return studentList.get(index);
    }
    return null;
  }

  /**
   * Deletes a Student by their ID if they exist
   *
   * @param id ID for the Student to delete
   */
  public void deleteStudent(int id) {
    /*
    Same as getStudentById method we can pass a student with only the ID field,
    and it will return that specific student if it exists
     */
    studentList.remove(new Student(id));
  }

  /**
   * Updates a Students information. This method will not update their ID.
   *
   * @param id      ID of the Student to update
   * @param student New Student data
   * @return Returns the Student data after it has been updated
   */
  public Student updateStudent(int id, Student student) {
    int index = studentList.indexOf(student);
    if (!studentList.contains(student)) {
      return null;
    }
    studentList.set(index, student);
    return studentList.get(index);
  }
}

package com.csc340.restapidemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentsFileController implements FileControllerBase {

    private static StudentsFileController instance = null;

    private final File studentsFile;
    private final ObjectMapper mapper = new ObjectMapper();

    private StudentsFileController() {
        studentsFile = new File("studentDb.json");
        createFile();
    }

    public static synchronized StudentsFileController getInstance() {
        if (instance == null) {
            instance = new StudentsFileController();
        }
        return instance;
    }

    @Override
    public void createFile() {
        try {
            // Creates new file is one does not exists
            if (studentsFile.createNewFile()) {
                System.out.println("Created file: " + studentsFile);
                initializeDb();
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + studentsFile);
            // Ignore error, no "robust logging" needed here
            e.printStackTrace();
        }
    }

    /**
     * Initializes the file with a key of "studentsList" and
     * a corresponding value of the empty list of students
     */
    void initializeDb(){
        try{
            StudentDataBase studentDataBase = new StudentDataBase();
            mapper.writeValue(studentsFile, studentDataBase);
        }
        catch(IOException e){
            // Ignore error, no "robust logging" needed here
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> addStudent(Student student){
        try{
            StudentDataBase studentDataBase = mapper.readValue(studentsFile, StudentDataBase.class);
            studentDataBase.addStudent(student);
            mapper.writeValue(studentsFile, studentDataBase);
            return studentDataBase.getStudentList();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getStudents() {
    try{
        StudentDataBase studentDataBase = mapper.readValue(studentsFile, StudentDataBase.class);
        return studentDataBase.getStudentList();
    }
    catch (IOException e){
        e.printStackTrace();
    }
    return null;
    }

    @Override
    public Student getStudentById(int id) {
        try{
            StudentDataBase studentDataBase = mapper.readValue(studentsFile, StudentDataBase.class);
            return studentDataBase.getStudentById(id);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Student updateStudent(int id, Student student) {
        try{
            StudentDataBase studentDataBase = mapper.readValue(studentsFile, StudentDataBase.class);
            Student newStudent = studentDataBase.updateStudent(id, student);
            mapper.writeValue(studentsFile, studentDataBase);
            return newStudent;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> deleteStudent(int id) {
        try{
            StudentDataBase studentDataBase = mapper.readValue(studentsFile, StudentDataBase.class);
            studentDataBase.deleteStudent(id);
            mapper.writeValue(studentsFile, studentDataBase);
            return studentDataBase.getStudentList();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}

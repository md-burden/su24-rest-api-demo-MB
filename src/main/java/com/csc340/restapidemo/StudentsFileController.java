package com.csc340.restapidemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StudentsFileController implements FileControllerBase {

    private static StudentsFileController instance = null;

    private final File studentsFile;

    private StudentsFileController() {
        studentsFile = new File("studentDb.json");
        createFile();
    }

    ;

    public static synchronized StudentsFileController getInstance() {
        if (instance == null) {
            instance = new StudentsFileController();
        }
        return instance;
    }

    @Override
    public void createFile() {
        try {
            // Creates new file is one does not exits
            if (studentsFile.createNewFile()) {
                System.out.println("Created file: " + studentsFile);
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + studentsFile);
            // Ignore error, no "robust logging" needed here
            e.printStackTrace();
        }
    }

    void initializeDb(){
        try(FileWriter studentsFileWriter = new FileWriter(studentsFile)){
            String init = "{\"students\":[]\"}";

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(Student student){
        try (FileWriter studentsFileWriter = new FileWriter(studentsFile)){

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getStudents() {

    }

    @Override
    public void updateStudent() {

    }

    @Override
    public void deleteStudent() {}
}

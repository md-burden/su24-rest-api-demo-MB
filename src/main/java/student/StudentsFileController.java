package student;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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


    /**
     * Creates a new DB file if one does not exist.
     */
    @Override
    public void createFile() {
        try {
            if (studentsFile.createNewFile()) {
                System.out.println("Created file: " + studentsFile);
                initializeDb();
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + studentsFile);
            Logger.getLogger(StudentsFileController.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(StudentsFileController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Deserializes the JSON database into a StudentDataBase object.
     * Then adds the Student to the database object and writes the update data to the file.
     * @param student Student data to add
     * @return Updated list of Students
     */
    @Override
    public List<Student> addStudent(Student student){
        try{
            StudentDataBase studentDataBase = mapper.readValue(studentsFile, StudentDataBase.class);
            studentDataBase.addStudent(student);
            mapper.writeValue(studentsFile, studentDataBase);
            return studentDataBase.getStudentList();
        }
        catch (IOException e) {
            Logger.getLogger(StudentsFileController.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @return List of current Students
     */
    @Override
    public List<Student> getStudents() {
    try{
        StudentDataBase studentDataBase = mapper.readValue(studentsFile, StudentDataBase.class);
        return studentDataBase.getStudentList();
    }
    catch (IOException e){
        Logger.getLogger(StudentsFileController.class.getName()).log(Level.SEVERE, null, e);
    }
    return null;
    }

    /**
     * Deserializes the JSON database and searches for a Student by their ID.
     * @param id ID of the Student
     * @return Student with given ID, otherwise null
     */
    @Override
    public Student getStudentById(int id) {
        try{
            StudentDataBase studentDataBase = mapper.readValue(studentsFile, StudentDataBase.class);
            return studentDataBase.getStudentById(id);
        }
        catch (IOException e){
            Logger.getLogger(StudentsFileController.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

    /**
     * Updates the information of a specific Student. Will not update their ID.
     * @param id ID of Student to update
     * @param student New Student data
     * @return Updated Student
     */
    @Override
    public Student updateStudent(int id, Student student) {
        try{
            StudentDataBase studentDataBase = mapper.readValue(studentsFile, StudentDataBase.class);
            Student newStudent = studentDataBase.updateStudent(id, student);
            mapper.writeValue(studentsFile, studentDataBase);
            return newStudent;
        }
        catch (IOException e){
            Logger.getLogger(StudentsFileController.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * Deletes a Student if one exists for the given ID
     * @param id ID of the Student to delete
     * @return Updated list of Students
     */
    @Override
    public List<Student> deleteStudent(int id) {
        try{
            StudentDataBase studentDataBase = mapper.readValue(studentsFile, StudentDataBase.class);
            studentDataBase.deleteStudent(id);
            mapper.writeValue(studentsFile, studentDataBase);
            return studentDataBase.getStudentList();
        }
        catch(IOException e){
            Logger.getLogger(StudentsFileController.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}

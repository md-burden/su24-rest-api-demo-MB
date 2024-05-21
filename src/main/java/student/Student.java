package student;

public class Student {

    private int id;
    private  String name;

    private String major;

    private double gpa;

    // Added default constructor for Jackson deserialization
    public Student(){}

    public Student(int id, String name, String major, double gpa) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }

    public Student(int id){
        this.id = id;
        name = "";
        major = "";
        gpa = 0.0;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Only checks ID of incoming student
     * @param obj
     * @return true if ID matches, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // Makes sure incoming object is of [this] class type
        if(obj.getClass() != this.getClass()){
            return false;
        }

        // Only checks student ID since it is the unique identifier.
        // Two students could have the same name but should NOT have the
        // same ID.
        Student student = (Student) obj;
        return student.id == this.id;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \n ID: %d \n Major: %s \n GPA: %.2f", name, id, major, gpa);
    }
}

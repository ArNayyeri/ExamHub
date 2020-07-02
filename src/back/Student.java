package back;

import java.util.ArrayList;

public class Student extends User {
    private String id;
    private ArrayList<ExamStudent> examStudents = new ArrayList<>();

    public ArrayList<ExamStudent> getExamStudents() {
        return examStudents;
    }



    public Student(String firstname, String lastname, String username, String password, String id) {
        super(firstname, lastname, username, password);
        this.id = id;
    }

    public String getId() {
        return id;
    }

}

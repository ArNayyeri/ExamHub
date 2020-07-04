package back;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Student extends User implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return student.getUsername().equals(getUsername());
    }
}

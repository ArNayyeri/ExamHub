package back;

import back.Manager;
import back.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class Save implements Serializable {
    public ArrayList<Manager> managers = new ArrayList<>();
    public ArrayList<Student> students = new ArrayList<>();

    public Save(ArrayList<Manager> managers, ArrayList<Student> students) {
        this.managers = managers;
        this.students = students;
    }
}

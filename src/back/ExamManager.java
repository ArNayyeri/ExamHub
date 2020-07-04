package back;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class ExamManager implements Serializable {
    private Chat chat = new Chat();
    private String name;
    private Manager manager;
    private ArrayList<Student> students = new ArrayList<>();
    private Calendar start;
    private Calendar end;
    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<ExamStudent> examStudents = new ArrayList<>();

    public Chat getChat() {
        return chat;
    }

    public ArrayList<ExamStudent> getExamStudents() {
        return examStudents;
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Calendar getStart() {
        return start;
    }

    public Calendar getEnd() {
        return end;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public double getAverage() {
        double average = 0;
        for (ExamStudent examStudent : examStudents) {
            if (examStudent.getGrade() == -1)
                return -1;
            average += examStudent.getGrade();
        }
        average = Math.ceil((average / examStudents.size()) * 100) / 100;
        return average;
    }

    public ExamManager(String name, Manager manager, Calendar start, Calendar end) {
        this.name = name;
        this.manager = manager;
        this.start = start;
        this.end = end;
    }
}

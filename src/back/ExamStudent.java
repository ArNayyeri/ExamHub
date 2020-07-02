package back;

import java.util.ArrayList;
import java.util.Calendar;

public class ExamStudent {
    private Chat chat = new Chat();
    private String name;
    private Manager manager;
    private Student student;
    private Calendar start;
    private Calendar end;
    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<Answer> answers = new ArrayList<>();
    private double grade = -1;

    public Chat getChat() {
        return chat;
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public Student getStudent() {
        return student;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public ExamStudent(ExamManager examManager, Student student) {
        this.name = examManager.getName();
        this.manager = examManager.getManager();
        this.student = student;
        this.start = examManager.getStart();
        this.end = examManager.getEnd();
        this.chat = examManager.getChat();
        this.questions = examManager.getQuestions();
    }
}

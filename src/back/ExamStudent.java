package back;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ExamStudent implements Serializable {
    private Chat chat;
    private String name;
    private Manager manager;
    private Student student;
    private Date start;
    private Date end;
    private ExamManager examManager;
    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<Answer> answers = new ArrayList<>();
    private boolean consecutive = true;
    private boolean access = true;

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public boolean isConsecutive() {
        return consecutive;
    }

    public void setConsecutive(boolean consecutive) {
        this.consecutive = consecutive;
    }

    public Chat getChat() {
        return chat;
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public Student getStudent() {
        return student;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public double getGrade() {
        int n = 0;
        double S = 0;
        for (Answer answer : answers) {
            if (answer.getGrade() < 0)
                n++;
            else
                S += answer.getGrade();
        }
        if (n == answers.size())
            return -1;
        return S;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ExamStudent(ExamManager examManager, Student student) {
        this.examManager = examManager;
        this.name = examManager.getName();
        this.manager = examManager.getManager();
        this.student = student;
        this.start = examManager.getStart();
        this.end = examManager.getEnd();
        this.chat = examManager.getChat();
        this.questions = examManager.getQuestions();
        this.consecutive = examManager.isConsecutive();
    }
}

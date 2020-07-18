package back.student;

import back.answer.Answer;
import back.chat.Chat;
import back.manager.ExamManager;
import back.manager.Manager;
import back.question.Question;

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
    private Poll poll;
    private boolean random = false;
    private boolean finish = false;

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setExamManager(ExamManager examManager) {
        this.examManager = examManager;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public ExamManager getExamManager() {
        return examManager;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public boolean isRandom() {
        return random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

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
        this.random = examManager.isRandom();
    }
}

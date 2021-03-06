package back.manager;

import back.chat.Chat;
import back.question.Question;
import back.student.ExamStudent;
import back.student.ExamStudentSort;
import back.student.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ExamManager implements Serializable {
    private Chat chat = new Chat();
    private String name;
    private Manager manager;
    private ArrayList<Student> students = new ArrayList<>();
    private Date start;
    private Date end;
    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<ExamStudent> examStudents = new ArrayList<>();
    private boolean consecutive = true;
    private boolean random = false;
    private boolean review = true;

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setName(String name) {
        this.name = name;
        for (ExamStudent examStudent : examStudents)
            examStudent.setName(name);
    }

    public void setStart(Date start) {
        this.start = start;
        for (ExamStudent examStudent : examStudents)
            examStudent.setStart(start);
    }

    public void setEnd(Date end) {
        this.end = end;
        for (ExamStudent examStudent : examStudents)
            examStudent.setEnd(end);
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public boolean isReview() {
        return review;
    }

    public void setReview(boolean review) {
        this.review = review;
    }

    public boolean isRandom() {
        return random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public boolean isConsecutive() {
        return consecutive;
    }

    public void setConsecutive(boolean consecutive) {
        this.consecutive = consecutive;
        for (ExamStudent examStudent : examStudents)
            examStudent.setConsecutive(consecutive);
    }

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

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setExamStudents(ArrayList<ExamStudent> examStudents) {
        this.examStudents = examStudents;
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

    public int getRank(ExamStudent examStudent) {
        ArrayList<ExamStudent> examStudents1 = new ArrayList<>(examStudents);
        examStudents1.sort(new ExamStudentSort());
        return examStudents1.indexOf(examStudent) + 1;
    }

    public ExamManager(String name, Manager manager, Date start, Date end) {
        this.name = name;
        this.manager = manager;
        this.start = start;
        this.end = end;
    }
}

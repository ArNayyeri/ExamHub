package back.answer;

import back.question.Question;

import java.io.Serializable;

public class Answer implements Serializable {
    private double grade = -1;
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Answer(Question question) {
        this.question = question;
    }
}

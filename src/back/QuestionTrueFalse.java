package back;

public class QuestionTrueFalse extends Question {
    private boolean correct;

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public QuestionTrueFalse(String text, int time, boolean correct) {
        super(text, time);
        this.correct = correct;
    }
}

package back;

public class AnswerTrueFalse extends Answer {
    private boolean answer;

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public AnswerTrueFalse(Question question, boolean answer) {
        super(question);
        this.answer = answer;
    }
}

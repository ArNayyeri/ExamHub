package back;

public class AnswerTest extends Answer {
    private byte answer;

    public byte getAnswer() {
        return answer;
    }

    public void setAnswer(byte answer) {
        this.answer = answer;
    }

    public AnswerTest(Question question, byte answer) {
        super(question);
        this.answer = answer;
    }
}

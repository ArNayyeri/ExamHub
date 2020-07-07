package back;

import java.io.Serializable;

public class QuestionTest extends Question implements Serializable {
    private String[] options = new String[4];
    private byte correct;

    public QuestionTest(String text, int time, String[] options, byte correct) {
        super(text, time);
        this.options = options;
        this.correct = correct;
    }

    public byte getCorrect() {
        return correct;
    }

    public void setCorrect(byte correct) {
        this.correct = correct;
    }

    public String[] getOptions() {
        return options;
    }
}

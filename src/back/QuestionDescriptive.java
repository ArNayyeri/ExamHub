package back;

import java.io.Serializable;

public class QuestionDescriptive extends Question implements Serializable {
    public QuestionDescriptive(String text, int time) {
        super(text, time);
    }
}

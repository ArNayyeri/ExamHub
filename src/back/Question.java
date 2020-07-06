package back;

import java.io.Serializable;

public class Question implements Serializable {
    private String Text;

    private int time = -1;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Question(String text, int time) {
        Text = text;
        this.time = time;
    }
}

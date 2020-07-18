package back.question;

import java.io.Serializable;

public class Question implements Serializable {
    private String Text;

    private double point;

    private int time = -1;

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

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

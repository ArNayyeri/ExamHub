package back;

import java.util.Calendar;

public class Message {
    private String text;
    private final User user;
    private final Calendar calendar;

    public Message(String text, User user, Calendar calendar) {
        this.text = text;
        this.user = user;
        this.calendar = calendar;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    public Calendar getCalendar() {
        return calendar;
    }
    public static void abc(){
        System.out.println("aaa");
    }
}

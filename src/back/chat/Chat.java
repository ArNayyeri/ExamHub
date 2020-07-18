package back.chat;

import java.io.Serializable;
import java.util.ArrayList;

public class Chat implements Serializable {
    private ArrayList<Message> messages=new ArrayList<>();
    
    public ArrayList<Message> getMessages() {
        return messages;
    }


}

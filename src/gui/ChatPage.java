/**
 * Sample Skeleton for 'ChatPage.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import back.chat.Message;
import back.manager.ExamManager;
import back.manager.Manager;
import back.student.ExamStudent;
import back.student.Student;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatPage extends Thread {
    public static Message message = null;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="list"
    private ListView<String> list; // Value injected by FXMLLoader

    @FXML // fx:id="textbox"
    private TextField textbox; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
        stop();
        if (ChatList.user instanceof Manager)
            try {
                MainClass.getMainClass().changescene("ManagerPage.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        else
            try {
                MainClass.getMainClass().changescene("StudentPage.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    void send(ActionEvent event) {
        Message message = new Message(textbox.getText(), ChatList.user, new Date(System.currentTimeMillis()));
        ChatList.chat.getMessages().add(message);
        refresh();
        Object o[] = new Object[3];
        o[0] = ChatList.user;
        if (ChatList.user instanceof Manager) {
            Manager manager = (Manager) ChatList.user;
            for (ExamManager examManager : manager.getExamManagers())
                if (examManager.getChat() == ChatList.chat)
                    o[1] = manager.getExamManagers().indexOf(examManager);
        } else {
            Student student = (Student) ChatList.user;
            for (ExamStudent examStudent : student.getExamStudents())
                if (examStudent.getChat() == ChatList.chat)
                    o[1] = student.getExamStudents().indexOf(examStudent);
        }
        o[2] = message;
        MainClass.getMainClass().data.save("Message Add", o);
    }

    @Override
    public void run() {
        while (true) {
            if (message != null) {
                ChatList.chat.getMessages().add(message);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        refresh();
                    }
                });
                message = null;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void refresh() {
        list.getItems().clear();
        for (Message message : ChatList.chat.getMessages()) {
            list.getItems().add(message.getUser().getUsername() + "\n\t" + message.getText() +
                    "\n" + message.getDate());
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert list != null : "fx:id=\"list\" was not injected: check your FXML file 'ChatPage.fxml'.";
        assert textbox != null : "fx:id=\"textbox\" was not injected: check your FXML file 'ChatPage.fxml'.";
        start();
    }
}

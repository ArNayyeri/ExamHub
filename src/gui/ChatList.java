/**
 * Sample Skeleton for 'ChatList.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.*;
import back.Chat;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ChatList {
    static User user;
    static Chat chat;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="list"
    private ListView<String> list; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
        if (ManagerLogin.manager != null)
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
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert list != null : "fx:id=\"list\" was not injected: check your FXML file 'ChatList.fxml'.";
        if (ManagerLogin.manager != null) {
            user = ManagerLogin.manager;
            for (ExamManager examManager : ManagerLogin.manager.getExamManagers()) {
                list.getItems().add(examManager.getName());
            }
        } else {
            user = StudentLogin.student;
            for (ExamStudent examStudent : StudentLogin.student.getExamStudents()) {
                list.getItems().add(examStudent.getName());
            }
        }

        list.getSelectionModel().selectedItemProperty().
                addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    int index = list.getSelectionModel().getSelectedIndex();
                    if (ManagerLogin.manager != null)
                        chat = ManagerLogin.manager.getExamManagers().get(index).getChat();
                    else
                        chat = StudentLogin.student.getExamStudents().get(index).getChat();
                    System.out.println("Item index : " + index);
                    try {
                        MainClass.getMainClass().changescene("ChatPage.fxml");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}

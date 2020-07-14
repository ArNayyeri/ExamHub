/**
 * Sample Skeleton for 'StudentPage.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StudentPage {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void My_Chats(ActionEvent event) {
        ManagerLogin.manager = null;
        try {
            MainClass.getMainClass().changescene("ChatList.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void My_Exams(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("MyExamsStudent.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}

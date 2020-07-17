package gui; /**
 * Sample Skeleton for 'FirstPage.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstPage implements Serializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void Login_Manager(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("ManagerLogin.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Login_Student(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("StudentLogin.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SignUp_Manager(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("AddManager.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SignUp_Student(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("AddStudent.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        MainClass.getMainClass().playmusic("/Music/Music 1.mp3");
    }
}

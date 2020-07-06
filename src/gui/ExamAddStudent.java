/**
 * Sample Skeleton for 'ExamAddStudent.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.ExamManager;
import back.Student;
import back.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ExamAddStudent {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="firstname"
    private TextField firstname; // Value injected by FXMLLoader

    @FXML // fx:id="lastname"
    private TextField lastname; // Value injected by FXMLLoader

    @FXML // fx:id="id"
    private TextField id; // Value injected by FXMLLoader

    @FXML
    void OK_Clicked(ActionEvent event) {
        ManagerLogin.manager.addStudentExam(MyExamsManager.examManager,
                id.getText(), firstname.getText(), lastname.getText());
        try {
            MainClass.getMainClass().changescene("ManagerExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert firstname != null : "fx:id=\"firstname\" was not injected: check your FXML file 'ExamAddStudent.fxml'.";
        assert lastname != null : "fx:id=\"lastname\" was not injected: check your FXML file 'ExamAddStudent.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'ExamAddStudent.fxml'.";

    }
}

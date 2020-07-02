package gui; /**
 * Sample Skeleton for 'ManagerLogin.fxml' Controller Class
 */

import back.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentLogin {
    MainClass mainClass;

    public StudentLogin() {
        this.mainClass = MainClass.getMainClass();
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // gui:id="usernametext"
    private TextField usernametext; // Value injected by FXMLLoader

    @FXML // gui:id="passwordtext"
    private TextField passwordtext; // Value injected by FXMLLoader

    @FXML // gui:id="OK"
    private Button OK; // Value injected by FXMLLoader

    @FXML
    void OK_Click(ActionEvent event) {
        Student student = mainClass.loginStudent(usernametext.getText(), passwordtext.getText());
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert usernametext != null : "gui:id=\"usernametext\" was not injected: check your FXML file 'ManagerLogin.fxml'.";
        assert passwordtext != null : "gui:id=\"passwordtext\" was not injected: check your FXML file 'ManagerLogin.fxml'.";
        assert OK != null : "gui:id=\"OK\" was not injected: check your FXML file 'ManagerLogin.fxml'.";

    }
}

package gui; /**
 * Sample Skeleton for 'AddStudent.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class AddStudent implements Serializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // gui:id="FirstnameText"
    private TextField FirstnameText; // Value injected by FXMLLoader

    @FXML // gui:id="LastnameText"
    private TextField LastnameText; // Value injected by FXMLLoader

    @FXML // gui:id="PasswordText"
    private TextField PasswordText; // Value injected by FXMLLoader

    @FXML // gui:id="UsernameText"
    private TextField UsernameText; // Value injected by FXMLLoader

    @FXML // gui:id="IDText"
    private TextField IDText; // Value injected by FXMLLoader

    @FXML
    void OK_Click(ActionEvent event) {
        MainClass.getMainClass().addStudent(FirstnameText.getText(), LastnameText.getText(),
                UsernameText.getText(), PasswordText.getText(), IDText.getText());
        try {
            MainClass.getMainClass().changescene("FirstPage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert FirstnameText != null : "gui:id=\"FirstnameText\" was not injected: check your FXML file 'AddStudent.fxml'.";
        assert LastnameText != null : "gui:id=\"LastnameText\" was not injected: check your FXML file 'AddStudent.fxml'.";
        assert PasswordText != null : "gui:id=\"PasswordText\" was not injected: check your FXML file 'AddStudent.fxml'.";
        assert UsernameText != null : "gui:id=\"UsernameText\" was not injected: check your FXML file 'AddStudent.fxml'.";
        assert IDText != null : "gui:id=\"IDText\" was not injected: check your FXML file 'AddStudent.fxml'.";

    }
}

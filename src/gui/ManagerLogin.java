package gui; /**
 * Sample Skeleton for 'ManagerLogin.fxml' Controller Class
 */

import back.manager.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerLogin{
    static Manager manager = null;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="usernametext"
    private TextField usernametext; // Value injected by FXMLLoader

    @FXML // fx:id="OK"
    private Button OK; // Value injected by FXMLLoader

    @FXML // fx:id="passwordtext"
    private PasswordField passwordtext; // Value injected by FXMLLoader


    @FXML
    void OK_Click(ActionEvent event) {
        manager = MainClass.getMainClass().loginManager(usernametext.getText(), passwordtext.getText());
        if (manager != null)
            try {
                MainClass.getMainClass().changescene("ManagerPage.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        else
            System.out.println("Account Already Exist");
    }

    @FXML
    void back(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("FirstPage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert usernametext != null : "gui:id=\"usernametext\" was not injected: check your FXML file 'ManagerLogin.fxml'.";
        assert passwordtext != null : "gui:id=\"passwordtext\" was not injected: check your FXML file 'ManagerLogin.fxml'.";
        assert OK != null : "gui:id=\"OK\" was not injected: check your FXML file 'ManagerLogin.fxml'.";

    }
}

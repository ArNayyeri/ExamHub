/**
 * Sample Skeleton for 'ExcelResult.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ExcelResult {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="text"
    private TextField text; // Value injected by FXMLLoader

    @FXML
    void OK(ActionEvent event) {
        if (MyExamsManager.examManager != null) {
            ManagerLogin.manager.examexcel(MyExamsManager.examManager, text.getText());
            try {
                MainClass.getMainClass().changescene("ManagerExam.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ManagerLogin.manager.averageexcel(text.getText());
            try {
                MainClass.getMainClass().changescene("ManagerPage.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert text != null : "fx:id=\"text\" was not injected: check your FXML file 'ExcelResult.fxml'.";

    }
}

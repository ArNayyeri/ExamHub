/**
 * Sample Skeleton for 'AddQuestion.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddQuestion {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void Descriptive(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("AddDescriptive.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Test(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("AddTest.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void True_False(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("AddTrueFalse.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("ManagerExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        EditQuestion.question = null;
    }
}

/**
 * Sample Skeleton for 'ManagerPage.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ManagerPage {


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void Chats(ActionEvent event) {

    }


    @FXML
    void Create_Exam(ActionEvent event) {
        MyExamsManager.examManager = null;
        try {
            MainClass.getMainClass().changescene("CreateExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void My_Exams(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("MyExamsManager.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}
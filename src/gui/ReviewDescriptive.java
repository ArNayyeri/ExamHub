/**
 * Sample Skeleton for 'ReviewDescriptive.fxml' Controller Class
 */

package gui;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import back.AnswerDescriptive;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReviewDescriptive {
    AnswerDescriptive answerDescriptive;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("StudentExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void show_answer(ActionEvent event) {
        Desktop desktop = Desktop.getDesktop();
        if (answerDescriptive.getFile() != null) {
            if (answerDescriptive.getFile().exists()) {
                try {
                    desktop.open(answerDescriptive.getFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else
            System.out.println("Javab Nist!!!");
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'ReviewDescriptive.fxml'.";
        answerDescriptive = (AnswerDescriptive) ReviewList.answer;
        label.setText(answerDescriptive.getQuestion().getText());
    }
}

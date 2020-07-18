/**
 * Sample Skeleton for 'ReviewDescriptive.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.answer.AnswerTrueFalse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReviewTrueFalse {
    AnswerTrueFalse answerTrueFalse;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML
    private Label answerlabel;

    @FXML
    void back(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("StudentExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'ReviewDescriptive.fxml'.";
        answerTrueFalse = (AnswerTrueFalse) ReviewList.answer;
        label.setText(answerTrueFalse.getQuestion().getText());
        if (answerTrueFalse.isAnswer())
            answerlabel.setText("Your Answer : True");
        else
            answerlabel.setText("Your Answer : False");
    }
}

/**
 * Sample Skeleton for 'ReviewDescriptive.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.answer.AnswerTest;
import back.question.QuestionTest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReviewTest {
    AnswerTest answerTest;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

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
        answerTest = (AnswerTest) ReviewList.answer;
        label.setText(answerTest.getQuestion().getText());
        QuestionTest questionTest = (QuestionTest) answerTest.getQuestion();
        label1.setText("1 : " + questionTest.getOptions()[0]);
        label2.setText("2 : " + questionTest.getOptions()[1]);
        label3.setText("3 : " + questionTest.getOptions()[2]);
        label4.setText("4 : " + questionTest.getOptions()[3]);
        answerlabel.setText("Your Answer : " + answerTest.getAnswer());
    }
}

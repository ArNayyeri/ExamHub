/**
 * Sample Skeleton for 'GradeStudent.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.answer.Answer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class GradeStudent {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="list"
    private ListView<String> list; // Value injected by FXMLLoader

    @FXML // fx:id="rank"
    private Label rank; // Value injected by FXMLLoader

    @FXML // fx:id="average"
    private Label average; // Value injected by FXMLLoader

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
        assert list != null : "fx:id=\"list\" was not injected: check your FXML file 'GradeStudent.fxml'.";
        assert rank != null : "fx:id=\"rank\" was not injected: check your FXML file 'GradeStudent.fxml'.";
        assert average != null : "fx:id=\"average\" was not injected: check your FXML file 'GradeStudent.fxml'.";
        for (Answer answer : MyExamsStudent.examStudent.getAnswers()) {
            if (answer.getGrade() != -1)
                list.getItems().add("Question " + MyExamsStudent.examStudent.getAnswers().indexOf(answer) +
                        " : " + answer.getGrade() + " / " + answer.getQuestion().getPoint());
            else
                list.getItems().add("Question 1 " + MyExamsStudent.examStudent.getAnswers().indexOf(answer) + " Still");
        }
        if (MyExamsStudent.examStudent.getExamManager().getAverage() != -1) {
            average.setText("Average : " + (MyExamsStudent.examStudent.getExamManager().getAverage()));
            rank.setText("Rank : " +
                    MyExamsStudent.examStudent.getExamManager().getRank(MyExamsStudent.examStudent));
        } else {
            average.setText("Average : Still");
            rank.setText("Rank : Still");
        }
    }
}

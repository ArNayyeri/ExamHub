/**
 * Sample Skeleton for 'CorrectionList.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.answer.Answer;
import back.answer.AnswerDescriptive;
import back.answer.AnswerTest;
import back.answer.AnswerTrueFalse;
import back.question.QuestionTest;
import back.question.QuestionTrueFalse;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CorrectionListStudent {
    static AnswerDescriptive answerDescriptive;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="list"
    private ListView<String> list; // Value injected by FXMLLoader

    @FXML
    void correctionTestTrueFalse(ActionEvent event) {
        for (Answer answer : CorrectionList.examStudent.getAnswers()) {
            if (answer instanceof AnswerTest) {
                AnswerTest answerTest = (AnswerTest) answer;
                QuestionTest questionTest = (QuestionTest) answerTest.getQuestion();
                if (answerTest.getAnswer() == questionTest.getCorrect())
                    answerTest.setGrade(questionTest.getPoint());
                else
                    answerTest.setGrade(0);
            }
            if (answer instanceof AnswerTrueFalse) {
                AnswerTrueFalse answerTrueFalse = (AnswerTrueFalse) answer;
                QuestionTrueFalse questionTrueFalse = (QuestionTrueFalse) answer.getQuestion();
                if (answerTrueFalse.isAnswer() == questionTrueFalse.isCorrect())
                    answerTrueFalse.setGrade(questionTrueFalse.getPoint());
                else
                    answerTrueFalse.setGrade(0);
            }
        }
        Object o[] = new Object[3];
        o[0] = CorrectionList.examStudent.getStudent();
        o[1] = CorrectionList.examStudent.getStudent().getExamStudents().indexOf(CorrectionList.examStudent);
        o[2] = CorrectionList.examStudent;
        MainClass.getMainClass().data.save("Correction Test TrueFalse", o);
    }

    @FXML
    void back(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("CorrectionList.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert list != null : "fx:id=\"list\" was not injected: check your FXML file 'CorrectionList.fxml'.";
        int w = 1;
        for (Answer answer : CorrectionList.examStudent.getAnswers()) {
            if (answer instanceof AnswerDescriptive) {
                list.getItems().add("Descriptive Question " + w);
                w++;
            }
        }
        list.getSelectionModel().selectedItemProperty().
                addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    int index = list.getSelectionModel().getSelectedIndex();
                    int z = 0;
                    for (Answer answer : CorrectionList.examStudent.getAnswers()) {
                        if (answer instanceof AnswerDescriptive) {
                            if (z == index) {
                                answerDescriptive = (AnswerDescriptive) answer;
                                break;
                            }
                            z++;
                        }
                    }
                    System.out.println("Item index : " + index);
                    try {
                        MainClass.getMainClass().changescene("CorrectionDescriptive.fxml");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}

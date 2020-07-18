/**
 * Sample Skeleton for 'EditQuestion.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.manager.ExamManager;
import back.question.Question;
import back.question.QuestionDescriptive;
import back.question.QuestionTest;
import back.question.QuestionTrueFalse;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class EditQuestion {
    public static Question question = null;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="List"
    private ListView<String> List; // Value injected by FXMLLoader

    @FXML
    void Back(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("ManagerExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert List != null : "fx:id=\"List\" was not injected: check your FXML file 'EditQuestion.fxml'.";
        ExamManager examManager = MyExamsManager.examManager;
        for (Question question : MyExamsManager.examManager.getQuestions()) {
            List.getItems().add("Question " + (MyExamsManager.examManager.getQuestions().indexOf(question) + 1));
        }
        List.getSelectionModel().selectedItemProperty().
                addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    int index = List.getSelectionModel().getSelectedIndex();
                    question = MyExamsManager.examManager.getQuestions().get(index);
                    System.out.println("Item index : " + index);
                    if (question instanceof QuestionDescriptive)
                        try {
                            MainClass.getMainClass().changescene("AddDescriptive.fxml");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    else if (question instanceof QuestionTest)
                        try {
                            MainClass.getMainClass().changescene("AddTest.fxml");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    else if (question instanceof QuestionTrueFalse)
                        try {
                            MainClass.getMainClass().changescene("AddTrueFalse.fxml");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                });
    }
}

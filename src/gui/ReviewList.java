/**
 * Sample Skeleton for 'ReviewList.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ReviewList {
    static Answer answer;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="list"
    private ListView<String> list; // Value injected by FXMLLoader

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
        assert list != null : "fx:id=\"list\" was not injected: check your FXML file 'ReviewList.fxml'.";
        for (int i = 1; i <= MyExamsStudent.examStudent.getAnswers().size(); i++) {
            list.getItems().add("Question " + i);
        }
        list.getSelectionModel().selectedItemProperty().
                addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    int index = list.getSelectionModel().getSelectedIndex();
                    answer = MyExamsStudent.examStudent.getAnswers().get(index);
                    System.out.println("Item index : " + index);
                    if (answer instanceof AnswerDescriptive)
                        try {
                            MainClass.getMainClass().changescene("ReviewDescriptive.fxml");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    if (answer instanceof AnswerTest)
                        try {
                            MainClass.getMainClass().changescene("ReviewTest.fxml");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    if (answer instanceof AnswerTrueFalse)
                        try {
                            MainClass.getMainClass().changescene("ReviewTrueFalse.fxml");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                });
    }
}

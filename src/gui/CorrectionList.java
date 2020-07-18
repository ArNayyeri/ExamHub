/**
 * Sample Skeleton for 'CorrectionList.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.student.ExamStudent;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CorrectionList {
    static ExamStudent examStudent;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="list"
    private ListView<String> list; // Value injected by FXMLLoader

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
        assert list != null : "fx:id=\"list\" was not injected: check your FXML file 'CorrectionList.fxml'.";
        for (ExamStudent examStudent : MyExamsManager.examManager.getExamStudents()) {
            list.getItems().add(examStudent.getStudent().getFirstname());
        }
        list.getSelectionModel().selectedItemProperty().
                addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    int index = list.getSelectionModel().getSelectedIndex();
                    examStudent = MyExamsManager.examManager.getExamStudents().get(index);
                    System.out.println("Item index : " + index);
                    try {
                        MainClass.getMainClass().changescene("CorrectionListStudent.fxml");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}

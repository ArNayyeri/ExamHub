/**
 * Sample Skeleton for 'MyExamsManager.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.ExamManager;
import back.ExamStudent;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MyExamsStudent {
    static ExamStudent examStudent = null;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="List"
    private ListView<String> List; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("FirstPage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert List != null : "fx:id=\"List\" was not injected: check your FXML file 'MyExamsManager.fxml'.";
        for (ExamStudent examStudent : StudentLogin.student.getExamStudents()) {
            List.getItems().add(examStudent.getName());
        }
        List.getSelectionModel().selectedItemProperty().
                addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    int index = List.getSelectionModel().getSelectedIndex();
                    examStudent = StudentLogin.student.getExamStudents().get(index);
                    System.out.println("Item index : " + index);
                    try {
                        MainClass.getMainClass().changescene("StudentExam.fxml");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}

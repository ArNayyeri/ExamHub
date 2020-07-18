/**
 * Sample Skeleton for 'StudentExamEdit.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.student.ExamStudent;
import back.student.Student;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class StudentExamEdit {
    static ExamStudent examStudent;

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
        assert List != null : "fx:id=\"List\" was not injected: check your FXML file 'StudentExamEdit.fxml'.";
        for (Student student : MyExamsManager.examManager.getStudents())
            List.getItems().add(student.getFirstname() + "  " + student.getLastname() + "  " + student.getId());
        List.getSelectionModel().selectedItemProperty().
                addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    int index = List.getSelectionModel().getSelectedIndex();
                    examStudent = MyExamsManager.examManager.getExamStudents().get(index);
                    System.out.println("Item index : " + index);
                    try {
                        MainClass.getMainClass().changescene("StudentAccess.fxml");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}

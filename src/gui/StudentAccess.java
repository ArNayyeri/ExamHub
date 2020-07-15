/**
 * Sample Skeleton for 'StudentAccess.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class StudentAccess {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="accessradio"
    private RadioButton accessradio; // Value injected by FXMLLoader

    @FXML // fx:id="LabelStudent"
    private Label LabelStudent; // Value injected by FXMLLoader

    @FXML
    void OK(ActionEvent event) {
        StudentExamEdit.examStudent.setAccess(accessradio.isSelected());
        Object o[] = new Object[3];
        o[0] = StudentExamEdit.examStudent.getStudent();
        o[1] = StudentExamEdit.examStudent.getStudent().getExamStudents().indexOf(StudentExamEdit.examStudent);
        o[2] = accessradio.isSelected();
        MainClass.getMainClass().data.save("Edit Access", o);
        try {
            MainClass.getMainClass().changescene("StudentExamEdit.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void remove(ActionEvent event) {
        Object o[] = new Object[3];
        o[0] = ManagerLogin.manager;
        o[1] = ManagerLogin.manager.getExamManagers().indexOf(MyExamsManager.examManager);
        o[2] = MyExamsManager.examManager.getExamStudents().indexOf(StudentExamEdit.examStudent);
        MyExamsManager.examManager.getExamStudents().remove(StudentExamEdit.examStudent);
        MyExamsManager.examManager.getStudents().remove(StudentExamEdit.examStudent.getStudent());
        StudentExamEdit.examStudent.getStudent().getExamStudents().remove(StudentExamEdit.examStudent);
        MainClass.getMainClass().data.save("Remove Student Exam", o);
        try {
            MainClass.getMainClass().changescene("StudentExamEdit.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert accessradio != null : "fx:id=\"accessradio\" was not injected: check your FXML file 'StudentAccess.fxml'.";
        assert LabelStudent != null : "fx:id=\"LabelStudent\" was not injected: check your FXML file 'StudentAccess.fxml'.";
        LabelStudent.setText(StudentExamEdit.examStudent.getStudent().getFirstname() + "\n" +
                StudentExamEdit.examStudent.getStudent().getLastname() + "\n" +
                StudentExamEdit.examStudent.getStudent().getId());
        accessradio.setSelected(StudentExamEdit.examStudent.isAccess());
    }
}

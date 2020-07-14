/**
 * Sample Skeleton for 'CorrectionDescriptive.fxml' Controller Class
 */

package gui;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CorrectionDescriptive {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="gradeText"
    private TextField gradeText; // Value injected by FXMLLoader

    @FXML
    void ok(ActionEvent event) {
        CorrectionListStudent.answerDescriptive.setGrade(Double.parseDouble(gradeText.getText()));
        Object o[] = new Object[4];
        o[0] = CorrectionList.examStudent.getStudent();
        o[1] = CorrectionList.examStudent.getStudent().getExamStudents().indexOf(CorrectionList.examStudent);
        o[2] = CorrectionList.examStudent.getAnswers().indexOf(CorrectionListStudent.answerDescriptive);
        o[3] = CorrectionListStudent.answerDescriptive.getGrade();
        MainClass.getMainClass().data.save("Correction Descriptive", o);
        try {
            MainClass.getMainClass().changescene("ManagerExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void show_answer(ActionEvent event) {
        Desktop desktop = Desktop.getDesktop();
        if (CorrectionListStudent.answerDescriptive.getFile() != null) {
            if (CorrectionListStudent.answerDescriptive.getFile().exists()) {
                try {
                    desktop.open(CorrectionListStudent.answerDescriptive.getFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else
            System.out.println("Javab Nist!!!");
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'CorrectionDescriptive.fxml'.";
        assert gradeText != null : "fx:id=\"gradeText\" was not injected: check your FXML file 'CorrectionDescriptive.fxml'.";
        label.setText(CorrectionListStudent.answerDescriptive.getQuestion().getText());
    }
}

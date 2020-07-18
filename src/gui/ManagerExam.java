/**
 * Sample Skeleton for 'ManagerExam.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ManagerExam {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void Back_Clicked(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("ManagerPage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Add_Question(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("AddQuestion.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Add_Student(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("ExamAddStudent.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Edit_Information(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("CreateExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Edit_Question(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("EditQuestion.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Student_Access(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("StudentExamEdit.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void correction(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("CorrectionList.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void excel(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("ExcelResult.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chart(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("Chart.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}

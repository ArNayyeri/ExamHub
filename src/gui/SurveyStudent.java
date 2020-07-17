/**
 * Sample Skeleton for 'SurveyStudent.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.Survey;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class SurveyStudent {

    ToggleGroup group = new ToggleGroup();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="good"
    private RadioButton good; // Value injected by FXMLLoader

    @FXML // fx:id="normal"
    private RadioButton normal; // Value injected by FXMLLoader

    @FXML // fx:id="bad"
    private RadioButton bad; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("StudentExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ok(ActionEvent event) {
        if (good.isSelected())
            MyExamsStudent.examStudent.setSurvey(Survey.good);
        if (normal.isSelected())
            MyExamsStudent.examStudent.setSurvey(Survey.normal);
        if (bad.isSelected())
            MyExamsStudent.examStudent.setSurvey(Survey.bad);
        Object o[] = new Object[3];
        o[0] = StudentLogin.student;
        o[1] = StudentLogin.student.getExamStudents().indexOf(MyExamsStudent.examStudent);
        o[2] = MyExamsStudent.examStudent;
        MainClass.getMainClass().data.save("Edit Survey", o);
        try {
            MainClass.getMainClass().changescene("StudentExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert good != null : "fx:id=\"good\" was not injected: check your FXML file 'SurveyStudent.fxml'.";
        assert normal != null : "fx:id=\"normal\" was not injected: check your FXML file 'SurveyStudent.fxml'.";
        assert bad != null : "fx:id=\"bad\" was not injected: check your FXML file 'SurveyStudent.fxml'.";
        good.setToggleGroup(group);
        normal.setToggleGroup(group);
        bad.setToggleGroup(group);
        if (MyExamsStudent.examStudent.getSurvey() == Survey.good)
            good.setSelected(true);
        if (MyExamsStudent.examStudent.getSurvey() == Survey.normal)
            normal.setSelected(true);
        if (MyExamsStudent.examStudent.getSurvey() == Survey.bad)
            bad.setSelected(true);
    }
}

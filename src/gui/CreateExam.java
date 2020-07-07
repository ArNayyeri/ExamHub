/**
 * Sample Skeleton for 'CreateExam.fxml' Controller Class
 */

package gui;

import java.io.File;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import back.ExamManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class CreateExam {
    File file = null;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button ChooseButton;

    @FXML
    private TextField nameText;

    @FXML
    private DatePicker Time;

    @FXML
    private TextField StartH;

    @FXML
    private TextField StartM;

    @FXML
    private TextField StartS;

    @FXML
    private TextField EndH;

    @FXML
    private TextField EndM;

    @FXML
    private TextField EndS;

    @FXML
    private RadioButton ExcelRadio;

    @FXML
    private RadioButton consecutive;

    @FXML
    private RadioButton random;

    @FXML
    void Choose_File(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Excel File");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
        fileChooser.getExtensionFilters().add(extFilter);
        file = fileChooser.showOpenDialog(MainClass.getMainClass().stage);
    }

    @FXML
    void OK(ActionEvent event) {
        LocalDate localDate = Time.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date datestart = Date.from(instant);
        datestart.setHours(Integer.parseInt(StartH.getText()));
        datestart.setMinutes(Integer.parseInt(StartM.getText()));
        datestart.setSeconds(Integer.parseInt(StartS.getText()));
        localDate = Time.getValue();
        instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date dateend = Date.from(instant);
        dateend.setHours(Integer.parseInt(EndH.getText()));
        dateend.setMinutes(Integer.parseInt(EndM.getText()));
        dateend.setSeconds(Integer.parseInt(EndS.getText()));
        if (MyExamsManager.examManager != null) {
            ExamManager examManager = new ExamManager(nameText.getText(), ManagerLogin.manager, datestart, dateend);
            examManager.setConsecutive(consecutive.isSelected());
            ManagerLogin.manager.getExamManagers().set(
                    ManagerLogin.manager.getExamManagers().indexOf(MyExamsManager.examManager), examManager);
            Object o[] = new Object[3];
            o[0] = examManager;
            o[1] = ManagerLogin.manager.getExamManagers().indexOf(examManager);
            int x[] = new int[examManager.getStudents().size()];
            for (int i = 0; i < examManager.getStudents().size(); i++)
                x[i] = examManager.getExamStudents().get(i).getStudent().
                        getExamStudents().indexOf(examManager.getExamStudents().get(i));
            o[2] = x;
            MainClass.getMainClass().data.save("Edit Exam", o);
        } else {
            if (file != null && ExcelRadio.isSelected()) {
                Object o[] = new Object[1];
                o[0] = ManagerLogin.manager.addExam(nameText.getText(), file.getPath(), datestart, dateend,
                        consecutive.isSelected(), random.isSelected());
                MainClass.getMainClass().data.save("Add Exam", o);
            } else {
                Object o[] = new Object[1];
                o[0] = ManagerLogin.manager.addExam(nameText.getText(), datestart, dateend
                        , consecutive.isSelected(), random.isSelected());
                MainClass.getMainClass().data.save("Add Exam", o);
            }
        }
        try {
            MainClass.getMainClass().changescene("ManagerPage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Excel_Clicked(ActionEvent event) {
        if (ExcelRadio.isSelected())
            ChooseButton.setDisable(false);
        else
            ChooseButton.setDisable(true);
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        if (MyExamsManager.examManager == null) {
            ChooseButton.setDisable(true);
            ChooseButton.setVisible(true);
            ExcelRadio.setDisable(false);
            ExcelRadio.setVisible(true);
        } else {
            ChooseButton.setDisable(true);
            ChooseButton.setVisible(false);
            ExcelRadio.setDisable(true);
            ExcelRadio.setVisible(false);
            nameText.setText(MyExamsManager.examManager.getName());
            LocalDate date = MyExamsManager.examManager.getStart()
                    .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Time.setValue(date);
            StartH.setText(String.valueOf(MyExamsManager.examManager.getStart().getHours()));
            StartM.setText(String.valueOf(MyExamsManager.examManager.getStart().getMinutes()));
            StartS.setText(String.valueOf(MyExamsManager.examManager.getStart().getSeconds()));
            EndH.setText(String.valueOf(MyExamsManager.examManager.getEnd().getHours()));
            EndM.setText(String.valueOf(MyExamsManager.examManager.getEnd().getMinutes()));
            EndS.setText(String.valueOf(MyExamsManager.examManager.getEnd().getSeconds()));
            consecutive.setSelected(MyExamsManager.examManager.isConsecutive());
            random.setSelected(MyExamsManager.examManager.isRandom());
        }
    }
}

/**
 * Sample Skeleton for 'AddDescriptive.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.QuestionTrueFalse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddTrueFalse {
    ToggleGroup group = new ToggleGroup();

    @FXML // fx:id="RadioF"
    private RadioButton RadioF; // Value injected by FXMLLoader

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Text"
    private TextArea Text; // Value injected by FXMLLoader

    @FXML // fx:id="Time"
    private TextField Time; // Value injected by FXMLLoader

    @FXML // fx:id="Radio"
    private RadioButton Radio; // Value injected by FXMLLoader

    @FXML
    private TextField point;

    @FXML
    private Button remove;

    @FXML
    void remove_Click(ActionEvent event) {
        Object o[] = new Object[3];
        o[0] = MyExamsManager.examManager.getManager();
        o[1] = MyExamsManager.examManager.getManager().getExamManagers().indexOf(MyExamsManager.examManager);
        o[2]=MyExamsManager.examManager.getQuestions().indexOf(EditQuestion.question);
        MyExamsManager.examManager.getQuestions().remove(EditQuestion.question);
        MainClass.getMainClass().data.save("Remove Question", o);
        try {
            MainClass.getMainClass().changescene("EditQuestion.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void OK(ActionEvent event) {
        if (EditQuestion.question != null) {
            QuestionTrueFalse questionTrueFalse = new QuestionTrueFalse(
                    Text.getText(), Integer.parseInt(Time.getText()), Radio.isSelected());
            questionTrueFalse.setPoint(Double.parseDouble(point.getText()));
            MyExamsManager.examManager.getQuestions().set(MyExamsManager.examManager.getQuestions().
                    indexOf(EditQuestion.question), questionTrueFalse);
            Object o[] = new Object[4];
            o[0] = ManagerLogin.manager;
            o[1] = ManagerLogin.manager.getExamManagers().indexOf(MyExamsManager.examManager);
            o[2] = MyExamsManager.examManager.getQuestions().indexOf(questionTrueFalse);
            o[3] = questionTrueFalse;
            MainClass.getMainClass().data.save("Edit Question", o);
            try {
                MainClass.getMainClass().changescene("EditQuestion.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            QuestionTrueFalse questionTrueFalse = new QuestionTrueFalse
                    (Text.getText(), Integer.parseInt(Time.getText()), Radio.isSelected());
            questionTrueFalse.setPoint(Double.parseDouble(point.getText()));
            MyExamsManager.examManager.getQuestions().add(questionTrueFalse);
            Object o[] = new Object[3];
            o[0] = ManagerLogin.manager;
            o[1] = ManagerLogin.manager.getExamManagers().indexOf(MyExamsManager.examManager);
            o[2] = questionTrueFalse;
            MainClass.getMainClass().data.save("New Add Question", o);
            try {
                MainClass.getMainClass().changescene("AddQuestion.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void back(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("AddQuestion.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Text != null : "fx:id=\"Text\" was not injected: check your FXML file 'AddTrueFalse.fxml'.";
        assert Time != null : "fx:id=\"Time\" was not injected: check your FXML file 'AddTrueFalse.fxml'.";
        assert Radio != null : "fx:id=\"Radio\" was not injected: check your FXML file 'AddTrueFalse.fxml'.";
        Radio.setToggleGroup(group);
        RadioF.setToggleGroup(group);
        if (EditQuestion.question != null) {
            QuestionTrueFalse questionTrueFalse = (QuestionTrueFalse) EditQuestion.question;
            Text.setText(EditQuestion.question.getText());
            Time.setText(String.valueOf(EditQuestion.question.getTime()));
            Radio.setSelected(questionTrueFalse.isCorrect());
            RadioF.setSelected(!questionTrueFalse.isCorrect());
            point.setText(String.valueOf(EditQuestion.question.getPoint()));
        }
        else
            remove.setVisible(false);
    }
}

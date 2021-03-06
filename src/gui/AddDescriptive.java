/**
 * Sample Skeleton for 'AddDescriptive.fxml' Controller Class
 */

package gui;

import back.question.QuestionDescriptive;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddDescriptive {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Text"
    private TextArea Text; // Value injected by FXMLLoader

    @FXML // fx:id="Time"
    private TextField Time; // Value injected by FXMLLoader

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
            QuestionDescriptive questionDescriptive = new QuestionDescriptive
                    (Text.getText(), Integer.parseInt(Time.getText()));
            questionDescriptive.setPoint(Double.parseDouble(point.getText()));
            MyExamsManager.examManager.getQuestions().set(MyExamsManager.examManager.getQuestions().
                    indexOf(EditQuestion.question), questionDescriptive);
            Object o[] = new Object[4];
            o[0] = ManagerLogin.manager;
            o[1] = ManagerLogin.manager.getExamManagers().indexOf(MyExamsManager.examManager);
            o[2] = MyExamsManager.examManager.getQuestions().indexOf(questionDescriptive);
            o[3] = questionDescriptive;
            MainClass.getMainClass().data.save("Edit Question", o);
            try {
                MainClass.getMainClass().changescene("EditQuestion.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            QuestionDescriptive questionDescriptive = new QuestionDescriptive(Text.getText(),
                    Integer.parseInt(Time.getText()));
            questionDescriptive.setPoint(Double.parseDouble(point.getText()));
            MyExamsManager.examManager.getQuestions().add(questionDescriptive);
            Object o[] = new Object[3];
            o[0] = ManagerLogin.manager;
            o[1] = ManagerLogin.manager.getExamManagers().indexOf(MyExamsManager.examManager);
            o[2] = questionDescriptive;
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
        assert Text != null : "fx:id=\"Text\" was not injected: check your FXML file 'AddDescriptive.fxml'.";
        assert Time != null : "fx:id=\"Time\" was not injected: check your FXML file 'AddDescriptive.fxml'.";
        if (EditQuestion.question != null) {
            Text.setText(EditQuestion.question.getText());
            Time.setText(String.valueOf(EditQuestion.question.getTime()));
            point.setText(String.valueOf(EditQuestion.question.getPoint()));
        } else
            remove.setVisible(false);
    }
}

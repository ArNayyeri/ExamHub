/**
 * Sample Skeleton for 'AddTest.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.QuestionDescriptive;
import back.QuestionTest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddTest {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Text"
    private TextArea Text; // Value injected by FXMLLoader

    @FXML // fx:id="Time"
    private TextField Time; // Value injected by FXMLLoader

    @FXML // fx:id="option1"
    private TextArea option1; // Value injected by FXMLLoader

    @FXML // fx:id="option2"
    private TextArea option2; // Value injected by FXMLLoader

    @FXML // fx:id="option3"
    private TextArea option3; // Value injected by FXMLLoader

    @FXML // fx:id="option4"
    private TextArea option4; // Value injected by FXMLLoader

    @FXML // fx:id="correct"
    private TextField correct; // Value injected by FXMLLoader

    @FXML
    void OK(ActionEvent event) {
        String x[] = new String[4];
        x[0] = option1.getText();
        x[1] = option2.getText();
        x[2] = option3.getText();
        x[3] = option4.getText();
        if (EditQuestion.question != null) {
             QuestionTest questionTest= new QuestionTest(Text.getText(), Integer.parseInt(Time.getText())
                    , x, Byte.parseByte(correct.getText()));
            MyExamsManager.examManager.getQuestions().set(MyExamsManager.examManager.getQuestions().
                    indexOf(EditQuestion.question),questionTest);
            Object o[]=new Object[4];
            o[0]=ManagerLogin.manager;
            o[1]=ManagerLogin.manager.getExamManagers().indexOf(MyExamsManager.examManager);
            o[2]=MyExamsManager.examManager.getQuestions().indexOf(questionTest);
            o[3]=questionTest;
            MainClass.getMainClass().data.save("Edit Question",o);
            try {
                MainClass.getMainClass().changescene("EditQuestion.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            QuestionTest questionTest = new QuestionTest(Text.getText(), Integer.parseInt(Time.getText())
                    , x, Byte.parseByte(correct.getText()));
            MyExamsManager.examManager.getQuestions().add(questionTest);
            Object o[] = new Object[3];
            o[0] = ManagerLogin.manager;
            o[1] = ManagerLogin.manager.getExamManagers().indexOf(MyExamsManager.examManager);
            o[2] = questionTest;
            MainClass.getMainClass().data.save("New Add Question",o);
            try {
                MainClass.getMainClass().changescene("AddQuestion.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Text != null : "fx:id=\"Text\" was not injected: check your FXML file 'AddTest.fxml'.";
        assert Time != null : "fx:id=\"Time\" was not injected: check your FXML file 'AddTest.fxml'.";
        assert option1 != null : "fx:id=\"option1\" was not injected: check your FXML file 'AddTest.fxml'.";
        assert option2 != null : "fx:id=\"option2\" was not injected: check your FXML file 'AddTest.fxml'.";
        assert option3 != null : "fx:id=\"option3\" was not injected: check your FXML file 'AddTest.fxml'.";
        assert option4 != null : "fx:id=\"option4\" was not injected: check your FXML file 'AddTest.fxml'.";
        assert correct != null : "fx:id=\"correct\" was not injected: check your FXML file 'AddTest.fxml'.";
        if (EditQuestion.question != null) {
            QuestionTest questionTest = (QuestionTest) EditQuestion.question;
            Text.setText(EditQuestion.question.getText());
            Time.setText(String.valueOf(EditQuestion.question.getTime()));
            option1.setText(questionTest.getOptions()[0]);
            option2.setText(questionTest.getOptions()[1]);
            option3.setText(questionTest.getOptions()[2]);
            option4.setText(questionTest.getOptions()[3]);
            correct.setText(String.valueOf(questionTest.getCorrect()));
        }
    }
}

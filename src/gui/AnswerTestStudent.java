/**
 * Sample Skeleton for 'AnswerTestStudent.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import back.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class AnswerTestStudent extends Thread {
    ToggleGroup group = new ToggleGroup();
    QuestionTest questionTest;
    AnswerTest answerTest;
    boolean exist = false;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="radio1"
    private RadioButton radio1; // Value injected by FXMLLoader

    @FXML // fx:id="next"
    private Button next; // Value injected by FXMLLoader

    @FXML // fx:id="remaining_Time"
    private Label remaining_Time; // Value injected by FXMLLoader

    @FXML // fx:id="remaining_Time1"
    private Label remaining_Time1; // Value injected by FXMLLoader

    @FXML // fx:id="remaining_TimeQ"
    private Label remaining_TimeQ; // Value injected by FXMLLoader

    @FXML // fx:id="radio2"
    private RadioButton radio2; // Value injected by FXMLLoader

    @FXML // fx:id="radio3"
    private RadioButton radio3; // Value injected by FXMLLoader

    @FXML // fx:id="radio4"
    private RadioButton radio4; // Value injected by FXMLLoader

    @FXML // fx:id="previous"
    private Button previous; // Value injected by FXMLLoader

    @FXML
    void finish(ActionEvent event) {
        if (radio1.isSelected())
            answerTest.setAnswer((byte) 1);
        else if (radio2.isSelected())
            answerTest.setAnswer((byte) 2);
        else if (radio3.isSelected())
            answerTest.setAnswer((byte) 3);
        else if (radio4.isSelected())
            answerTest.setAnswer((byte) 4);
        MyExamsStudent.examStudent.setFinish(true);
        Object o[] = new Object[3];
        o[0] = StudentLogin.student;
        o[1] = StudentLogin.student.getExamStudents().indexOf(MyExamsStudent.examStudent);
        o[2] = MyExamsStudent.examStudent.getAnswers();
        MainClass.getMainClass().data.save("Answer Student", o);
        try {
            MainClass.getMainClass().changescene("StudentExam.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void next_click(ActionEvent event) {
        if (radio1.isSelected())
            answerTest.setAnswer((byte) 1);
        else if (radio2.isSelected())
            answerTest.setAnswer((byte) 2);
        else if (radio3.isSelected())
            answerTest.setAnswer((byte) 3);
        else if (radio4.isSelected())
            answerTest.setAnswer((byte) 4);
        StudentExam.n++;
        if (MyExamsStudent.examStudent.getQuestions()
                .get(StudentExam.number[StudentExam.n]) instanceof QuestionTest) {
            try {
                MainClass.getMainClass().changescene("AnswerTestStudent.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (MyExamsStudent.examStudent.getQuestions()
                .get(StudentExam.number[StudentExam.n]) instanceof QuestionDescriptive) {
            try {
                MainClass.getMainClass().changescene("AnswerDescriptiveStudent.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (MyExamsStudent.examStudent.getQuestions()
                .get(StudentExam.number[StudentExam.n]) instanceof QuestionTrueFalse) {
            try {
                MainClass.getMainClass().changescene("AnswerTrueFalseStudent.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void previous_click(ActionEvent event) {
        if (radio1.isSelected())
            answerTest.setAnswer((byte) 1);
        else if (radio2.isSelected())
            answerTest.setAnswer((byte) 2);
        else if (radio3.isSelected())
            answerTest.setAnswer((byte) 3);
        else if (radio4.isSelected())
            answerTest.setAnswer((byte) 4);
        StudentExam.n--;
        if (MyExamsStudent.examStudent.getQuestions()
                .get(StudentExam.number[StudentExam.n]) instanceof QuestionTest) {
            try {
                MainClass.getMainClass().changescene("AnswerTestStudent.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (MyExamsStudent.examStudent.getQuestions()
                .get(StudentExam.number[StudentExam.n]) instanceof QuestionDescriptive) {
            try {
                MainClass.getMainClass().changescene("AnswerDescriptiveStudent.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (MyExamsStudent.examStudent.getQuestions()
                .get(StudentExam.number[StudentExam.n]) instanceof QuestionTrueFalse) {
            try {
                MainClass.getMainClass().changescene("AnswerTrueFalseStudent.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert radio1 != null : "fx:id=\"radio1\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert next != null : "fx:id=\"next\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert remaining_Time != null : "fx:id=\"remaining_Time\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert remaining_Time1 != null : "fx:id=\"remaining_Time1\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert remaining_TimeQ != null : "fx:id=\"remaining_TimeQ\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert radio2 != null : "fx:id=\"radio2\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert radio3 != null : "fx:id=\"radio3\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert radio4 != null : "fx:id=\"radio4\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert previous != null : "fx:id=\"previous\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        radio1.setToggleGroup(group);
        radio2.setToggleGroup(group);
        radio3.setToggleGroup(group);
        radio4.setToggleGroup(group);
        questionTest = (QuestionTest) MyExamsStudent.examStudent.getQuestions().
                get(StudentExam.number[StudentExam.n]);
        radio1.setText(questionTest.getOptions()[0]);
        radio2.setText(questionTest.getOptions()[1]);
        radio3.setText(questionTest.getOptions()[2]);
        radio4.setText(questionTest.getOptions()[3]);
        label.setText(questionTest.getText());
        if (!MyExamsStudent.examStudent.isConsecutive()) {
            remaining_TimeQ.setText("");
            remaining_Time1.setText("");
        }

        if (StudentExam.n == 0)
            previous.setVisible(false);
        else
            previous.setVisible(true);
        if (StudentExam.n == StudentExam.number.length - 1)
            next.setVisible(false);
        else
            next.setVisible(true);
        for (Answer answer : MyExamsStudent.examStudent.getAnswers()) {
            if (answer.getQuestion() == questionTest) {
                exist = true;
                answerTest = (AnswerTest) answer;
                if (answerTest.getAnswer() == 1)
                    radio1.setSelected(true);
                else if (answerTest.getAnswer() == 2)
                    radio2.setSelected(true);
                else if (answerTest.getAnswer() == 3)
                    radio3.setSelected(true);
                else if (answerTest.getAnswer() == 4)
                    radio4.setSelected(true);
            }
        }
        if (!exist) {
            answerTest = new AnswerTest(questionTest, (byte) 0);
            MyExamsStudent.examStudent.getAnswers().add(answerTest);
        }
        start();
    }

    @Override
    public void run() {
        int M = questionTest.getTime();
        int S = 0;
        long[] A = new long[1];
        while (true) {
            if (MyExamsStudent.examStudent.getEnd().getTime() == System.currentTimeMillis())
                finish(null);
            Date date = new Date(System.currentTimeMillis());
            A[0] = (MyExamsStudent.examStudent.getEnd().getHours() * 3600 +
                    MyExamsStudent.examStudent.getEnd().getMinutes() * 60 +
                    MyExamsStudent.examStudent.getEnd().getSeconds()) -
                    (date.getHours() * 3600 + date.getMinutes() * 60 + date.getSeconds());
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    remaining_Time.setText(A[0] / 3600 + " : ");
                    A[0] %= 3600;
                    remaining_Time.setText(remaining_Time.getText() + A[0] / 60 + " : ");
                    A[0] %= 60;
                    remaining_Time.setText(remaining_Time.getText() + A[0] + " : ");
                }
            });
            if (MyExamsStudent.examStudent.isConsecutive()) {
                int finalM = M;
                int finalS = S;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        remaining_TimeQ.setText(finalM + " : " + finalS);
                    }
                });
                if (S == 0) {
                    if (M == 0) {
                        if (StudentExam.n == StudentExam.number.length - 1)
                            finish(null);
                        else
                            next_click(null);
                        break;
                    }
                    M--;
                    S = 59;
                } else
                    S--;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

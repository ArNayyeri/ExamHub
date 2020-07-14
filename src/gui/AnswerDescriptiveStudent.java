/**
 * Sample Skeleton for 'AnswerTestStudent.fxml' Controller Class
 */

package gui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import back.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

public class AnswerDescriptiveStudent extends Thread {
    QuestionDescriptive questionDescriptive;
    AnswerDescriptive answerDescriptive;
    boolean exist = false;
    File file = null;
    static int M;
    static int S;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="next"
    private Button next; // Value injected by FXMLLoader

    @FXML // fx:id="remaining_Time"
    private Label remaining_Time; // Value injected by FXMLLoader

    @FXML // fx:id="remaining_Time1"
    private Label remaining_Time1; // Value injected by FXMLLoader

    @FXML // fx:id="remaining_TimeQ"
    private Label remaining_TimeQ; // Value injected by FXMLLoader

    @FXML // fx:id="previous"
    private Button previous; // Value injected by FXMLLoader

    @FXML
    void show_answer(ActionEvent event) {
        Desktop desktop = Desktop.getDesktop();
        if (file != null)
            if (file.exists()) {
                try {
                    desktop.open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

    @FXML
    void get_answer(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Picture");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg");
        fileChooser.getExtensionFilters().add(extFilter);
        file = fileChooser.showOpenDialog(MainClass.getMainClass().stage);
    }

    @FXML
    void finish(ActionEvent event) {
        answerDescriptive.setFile(file);
        MyExamsStudent.examStudent.setFinish(true);
        stop();
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
        answerDescriptive.setFile(file);
        stop();
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
        answerDescriptive.setFile(file);
        stop();
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
        assert next != null : "fx:id=\"next\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert remaining_Time != null : "fx:id=\"remaining_Time\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert remaining_Time1 != null : "fx:id=\"remaining_Time1\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert remaining_TimeQ != null : "fx:id=\"remaining_TimeQ\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        assert previous != null : "fx:id=\"previous\" was not injected: check your FXML file 'AnswerTestStudent.fxml'.";
        questionDescriptive = (QuestionDescriptive) MyExamsStudent.examStudent.getQuestions().
                get(StudentExam.number[StudentExam.n]);
        label.setText(questionDescriptive.getText());
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
            if (answer.getQuestion() == questionDescriptive) {
                exist = true;
                answerDescriptive = (AnswerDescriptive) answer;
                if (answerDescriptive.getFile() != null)
                    file = answerDescriptive.getFile();
            }
        }
        if (!exist) {
            answerDescriptive = new AnswerDescriptive(questionDescriptive, null);
            MyExamsStudent.examStudent.getAnswers().add(answerDescriptive);
        }
        start();
    }

    @Override
    public void run() {
        if (M == -1) {
            M = questionDescriptive.getTime();
            S = 0;
        }
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
                    remaining_Time.setText(remaining_Time.getText() + A[0]);
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

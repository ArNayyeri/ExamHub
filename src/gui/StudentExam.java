/**
 * Sample Skeleton for 'StudentExam.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import back.question.QuestionDescriptive;
import back.question.QuestionTest;
import back.question.QuestionTrueFalse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StudentExam extends Thread {
    static int number[];
    static int n;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="start"
    private Button start; // Value injected by FXMLLoader

    @FXML // fx:id="review"
    private Button review; // Value injected by FXMLLoader

    @FXML // fx:id="poll"
    private Button poll; // Value injected by FXMLLoader

    @FXML // fx:id="namelabel"
    private Label namelabel; // Value injected by FXMLLoader

    @FXML // fx:id="start_timelabel"
    private Label start_timelabel; // Value injected by FXMLLoader

    @FXML // fx:id="endtime_label"
    private Label endtime_label; // Value injected by FXMLLoader

    @FXML // fx:id="question_label"
    private Label question_label; // Value injected by FXMLLoader

    @FXML
    private Label access;

    @FXML
    private Button grade;

    @FXML
    void grade_Click(ActionEvent event) {
        try {
            MainClass.getMainClass().changescene("GradeStudent.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(ActionEvent event) {
        stop();
        try {
            MainClass.getMainClass().changescene("StudentPage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void review_Click(ActionEvent event) {
        stop();
        try {
            MainClass.getMainClass().changescene("ReviewList.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void start_Click(ActionEvent event) {
        stop();
        number = new int[MyExamsStudent.examStudent.getQuestions().size()];
        AnswerDescriptiveStudent.M = -1;
        AnswerTrueFalseStudent.M = -1;
        AnswerTestStudent.M = -1;
        if (MyExamsStudent.examStudent.isRandom()) {
            ArrayList<Integer> x = new ArrayList<>();
            for (int i = 0; i < MyExamsStudent.examStudent.getQuestions().size(); i++) {
                int r = (int) (Math.random() * MyExamsStudent.examStudent.getQuestions().size());
                if (x.contains(r)) {
                    i--;
                    continue;
                }
                x.add(r);
                number[i] = r;
            }
        } else {
            for (int i = 0; i < MyExamsStudent.examStudent.getQuestions().size(); i++)
                number[i] = i;
        }
        n = 0;
        if (MyExamsStudent.examStudent.getQuestions().get(number[n]) instanceof QuestionTest) {
            try {
                MainClass.getMainClass().changescene("AnswerTestStudent.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (MyExamsStudent.examStudent.getQuestions().get(number[n]) instanceof QuestionDescriptive) {
            try {
                MainClass.getMainClass().changescene("AnswerDescriptiveStudent.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (MyExamsStudent.examStudent.getQuestions().get(number[n]) instanceof QuestionTrueFalse) {
            try {
                MainClass.getMainClass().changescene("AnswerTrueFalseStudent.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void poll_Click(ActionEvent event) {
        stop();
        try {
            MainClass.getMainClass().changescene("PollStudent.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date(System.currentTimeMillis());
            if (MyExamsStudent.examStudent.getStart().compareTo(date) > 0) {
                start.setDisable(true);
                review.setDisable(true);
                grade.setDisable(true);
                poll.setDisable(true);
            } else if (MyExamsStudent.examStudent.getStart().compareTo(date) <= 0 &&
                    MyExamsStudent.examStudent.getEnd().compareTo(date) > 0) {
                start.setDisable(false);
                review.setDisable(true);
                grade.setDisable(true);
                poll.setDisable(true);
            } else {
                start.setDisable(true);
                review.setDisable(false);
                grade.setDisable(false);
                poll.setDisable(false);
                stop();
            }
            if (MyExamsStudent.examStudent.isFinish())
                start.setDisable(true);
            if (!MyExamsStudent.examStudent.getExamManager().isReview())
                review.setDisable(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert start != null : "fx:id=\"start\" was not injected: check your FXML file 'StudentExam.fxml'.";
        assert review != null : "fx:id=\"review\" was not injected: check your FXML file 'StudentExam.fxml'.";
        assert poll != null : "fx:id=\"poll\" was not injected: check your FXML file 'StudentExam.fxml'.";
        assert namelabel != null : "fx:id=\"namelabel\" was not injected: check your FXML file 'StudentExam.fxml'.";
        assert start_timelabel != null : "fx:id=\"start_timelabel\" was not injected: check your FXML file 'StudentExam.fxml'.";
        assert endtime_label != null : "fx:id=\"endtime_label\" was not injected: check your FXML file 'StudentExam.fxml'.";
        assert question_label != null : "fx:id=\"question_label\" was not injected: check your FXML file 'StudentExam.fxml'.";
        namelabel.setText(MyExamsStudent.examStudent.getName());
        start_timelabel.setText("Start : " + MyExamsStudent.examStudent.getStart().toString());
        endtime_label.setText("End : " + MyExamsStudent.examStudent.getEnd().toString());
        question_label.setText(MyExamsStudent.examStudent.getQuestions().size() + " Questions");
        Date date = new Date(System.currentTimeMillis());
        if (MyExamsStudent.examStudent.getStart().compareTo(date) > 0) {
            start.setDisable(true);
            review.setDisable(true);
            grade.setDisable(true);
            poll.setDisable(true);
            start();
        } else if (MyExamsStudent.examStudent.getStart().compareTo(date) <= 0 &&
                MyExamsStudent.examStudent.getEnd().compareTo(date) > 0) {
            start.setDisable(false);
            grade.setDisable(true);
            review.setDisable(true);
            poll.setDisable(true);
            start();
        } else {
            start.setDisable(true);
            review.setDisable(false);
            grade.setDisable(false);
            poll.setDisable(false);
        }
        if (MyExamsStudent.examStudent.isFinish())
            start.setDisable(true);
        if (MyExamsStudent.examStudent.isAccess())
            access.setText("You have access");
        else {
            access.setText("You have not access");
            start.setDisable(true);
            review.setDisable(true);
            grade.setDisable(true);
            poll.setDisable(true);
        }
    }
}

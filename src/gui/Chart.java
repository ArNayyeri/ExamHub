/**
 * Sample Skeleton for 'Chart.fxml' Controller Class
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;

import back.ExamManager;
import back.ExamStudent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Chart {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="chart"
    private BarChart<String, Number> chart; // Value injected by FXMLLoader

    private CategoryAxis xAxis = new CategoryAxis();
    private NumberAxis yAxis = new NumberAxis();

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert chart != null : "fx:id=\"chart\" was not injected: check your FXML file 'Chart.fxml'.";
        chart = new BarChart<String, Number>(xAxis, yAxis);
        XYChart.Series series1 = new XYChart.Series();
        if (MyExamsManager.examManager != null) {
            series1.setName(MyExamsManager.examManager.getName());
            for (ExamStudent examStudent : MyExamsManager.examManager.getExamStudents())
                series1.getData().add(new XYChart.Data(examStudent.getStudent().getId(), examStudent.getGrade()));
        } else {
            series1.setName("Average of Exams");
            for (ExamManager examManager : ManagerLogin.manager.getExamManagers())
                series1.getData().add(new XYChart.Data(examManager.getName(), examManager.getAverage()));
        }
        chart.getData().addAll(series1);
    }
}

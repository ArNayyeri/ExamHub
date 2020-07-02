package gui;

import back.Manager;
import back.Student;
import back.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainClass extends Application {
    ArrayList<Manager> managers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    static MainClass mainClass;
    ArrayList<String> scenesname = new ArrayList<>();
    ArrayList<Scene> scenes = new ArrayList<>();
    Scene scene;
    Stage stage;

    public MainClass() {
        mainClass = this;
    }

    public void addStudent(String firstname, String lastname, String username, String password, String id) {
        if (User.getUser(username) == null)
            students.add(new Student(firstname, lastname, username, password, id));
        else {
            System.out.println("RIDIIIIIIIIIII:)");
        }

    }

    public void addManager(String firstname, String lastname, String username, String password) {
        if (User.getUser(username) == null)
            managers.add(new Manager(firstname, lastname, username, password));
        else {
            System.out.println("RIDIIIIIIIIIII:)");
        }
    }

    public Student loginStudent(String username, String password) {
        for (Student student : students) {
            if (student.getUsername().toUpperCase().equals(username.toUpperCase()) && student.getPassword().equals(password)) {
                return student;
            }
        }
        return null;
    }

    public Manager loginManager(String username, String password) {
        for (Manager manager : managers) {
            if (manager.getUsername().toUpperCase().equals(username.toUpperCase()) && manager.getPassword().equals(password)) {
                return manager;
            }
        }
        return null;
    }

    @Override
    public void start(Stage stage) throws Exception {
        scenesname.add("FirstPage.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FirstPage.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("ExamHub");
        scene = new Scene(root);
        scenes.add(scene);
        stage.setScene(scene);
        this.stage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void changestage(String name) throws Exception {
        if (sceneCreated(name) != null)
            scene = sceneCreated(name);
        else {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(name));
            Parent root = fxmlLoader.load();
            scene = new Scene(root);
            scenes.add(scene);
            scenesname.add(name);
        }
        stage.setScene(scene);
        stage.show();
    }

    private Scene sceneCreated(String name) {
        for (String i : scenesname)
            if (i.equals(name)) {
                return scenes.get(scenesname.indexOf(name));
            }
        return null;
    }

    public static MainClass getMainClass() {
        return mainClass;
    }
}
package gui;

import back.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class MainClass extends Application {
    public Data data = new Data();
    public ArrayList<Manager> managers = new ArrayList<>();
    public ArrayList<Student> students = new ArrayList<>();
    static MainClass mainClass;
    public Save save;
    Scene scene;
    Stage stage;

    public void addStudent(String firstname, String lastname, String username, String password, String id) {
        if (User.getUser(username) == null) {
            Student student = new Student(firstname, lastname, username, password, id);
            students.add(student);
            Object o[] = new Object[1];
            o[0] = student;
            data.save("New Student", o);
        } else {
            System.out.println("Account Already Exist");
        }

    }

    public void addManager(String firstname, String lastname, String username, String password) {
        if (User.getUser(username) == null) {
            Manager manager = new Manager(firstname, lastname, username, password);
            managers.add(manager);
            Object o[] = new Object[1];
            o[0] = manager;
            data.save("New Manager", o);
        } else {
            System.out.println("Account Already Exist");
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
        mainClass = this;
        File file = new File("Database.txt");
        if (file.exists()) {
            try {
                FileInputStream f = new FileInputStream(new File("Database.txt"));
                ObjectInputStream o = new ObjectInputStream(f);
                Save save = (Save) o.readObject();
                for (Manager manager : save.managers) {
                    MainClass.mainClass.managers.add(manager);
                    User.getUsers().add(manager);
                }
                for (Student student : save.students) {
                    MainClass.mainClass.students.add(student);
                    User.getUsers().add(student);
                }
                o.close();
                f.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        save = new Save(managers, students);
        data.start();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FirstPage.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("ExamHub");
        scene = new Scene(root);
        stage.setScene(scene);
        this.stage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void changescene(String name) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(name));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void playmusic(String path) {
        Media media = new Media(getClass().getResource(path).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public static MainClass getMainClass() {
        return mainClass;
    }

    public static void setMainClass(MainClass mainClass) {
        MainClass.mainClass = mainClass;
    }

    @Override
    public void stop() throws Exception {
        data.stop();
        super.stop();
        System.exit(0);
    }
}
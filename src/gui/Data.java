package gui;

import back.*;

import java.io.*;

public class Data extends Thread implements Serializable {
    boolean load = true;

    @Override
    public void run() {
        while (true) {
            try {
                File file = new File("NewSave.txt");
                if (file.exists() && load) {
                    FileInputStream f = new FileInputStream(file);
                    ObjectInputStream o = new ObjectInputStream(f);
                    String x = (String) o.readObject();
                    switch (x) {
                        case "New Student":
                            Student student = (Student) o.readObject();
                            MainClass.getMainClass().students.add(student);
                            User.getUsers().add(student);
                            break;
                        case "New Manager":
                            Manager manager = (Manager) o.readObject();
                            MainClass.getMainClass().managers.add(manager);
                            User.getUsers().add(manager);
                            break;
                        case "Add Exam":
                            ExamManager examManager = (ExamManager) o.readObject();
                            Manager manager1 = (Manager) User.getUser(examManager.getManager().getUsername());
                            manager1.getExamManagers().add(examManager);
                            examManager.setManager(manager1);
                            for (ExamStudent examStudent : examManager.getExamStudents()) {
                                if (User.getUser(examStudent.getStudent().getUsername()) != null) {
                                    Student student1 = (Student) User.getUser(examStudent.getStudent().getUsername());
                                    student1.getExamStudents().add(examStudent);
                                    examStudent.setManager(manager1);
                                    examStudent.setStudent(student1);
                                } else {
                                    User.getUsers().add(examStudent.getStudent());
                                    MainClass.getMainClass().students.add(examStudent.getStudent());
                                }
                            }
                            break;
                        case "Add Student Exam":
                            ExamManager examManager1 = (ExamManager) o.readObject();
                            Student student1 = (Student) o.readObject();
                            if (User.getUser(student1.getUsername()) == null) {
                                MainClass.getMainClass().students.add(student1);
                                User.getUsers().add(student1);
                            } else
                                student1 = (Student) User.getUser(student1.getUsername());
                            ExamStudent examStudent = new ExamStudent(examManager1, student1);
                            examManager1.getStudents().add(student1);
                            examManager1.getExamStudents().add(examStudent);
                            student1.getExamStudents().add(examStudent);
                            break;
                        case "New Add Question":
                            Manager manager2 = (Manager) o.readObject();
                            int i = (int) o.readObject();
                            manager = (Manager) User.getUser(manager2.getUsername());
                            examManager = manager.getExamManagers().get(i);
                            Question question = (Question) o.readObject();
                            examManager.getQuestions().add(question);
                            break;
                        case "Edit Question":
                            manager2 = (Manager) o.readObject();
                            i = (int) o.readObject();
                            int j = (int) o.readObject();
                            manager = (Manager) User.getUser(manager2.getUsername());
                            examManager = manager.getExamManagers().get(i);
                            question = (Question) o.readObject();
                            examManager.getQuestions().set(j, question);
                            break;
                        case "Edit Access":
                            student = (Student) o.readObject();
                            i = (int) o.readObject();
                            student1 = (Student) User.getUser(student.getUsername());
                            boolean q = (boolean) o.readObject();
                            student1.getExamStudents().get(i).setAccess(q);
                            break;
                        case "Edit Exam":
                            examManager = (ExamManager) o.readObject();
                            i = (int) o.readObject();
                            manager1 = (Manager) User.getUser(examManager.getManager().getUsername());
                            manager1.getExamManagers().set(i, examManager);
                            examManager.setManager(manager1);
                            j = 0;
                            int y[] = (int[]) o.readObject();
                            for (ExamStudent examStudent2 : examManager.getExamStudents()) {
                                student1 = (Student) User.getUser(examStudent2.getStudent().getUsername());
                                student1.getExamStudents().set(y[j], examStudent2);
                                examStudent2.setManager(manager1);
                                examStudent2.setStudent(student1);
                                j++;
                            }
                            break;
                    }
                    o.close();
                    f.close();
                    Thread.sleep(600);
                }
                Thread.sleep(400);
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void save(String change, Object object[]) {
        try {
            FileOutputStream f = new FileOutputStream(new File("Database.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(MainClass.mainClass.save);
            o.close();
            f.close();
            File file = new File("NewSave.txt");
            f = new FileOutputStream(file);
            o = new ObjectOutputStream(f);
            o.writeObject(change);
            for (Object oo : object)
                o.writeObject(oo);
            o.close();
            f.close();
            load = false;
            Thread.sleep(800);
            file.delete();
            load = true;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

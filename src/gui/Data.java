package gui;

import back.*;

import java.io.*;

public class Data extends Thread implements Serializable {

    @Override
    public void run() {
        while (true) {
            try {
                File file = new File("NewSave.txt");
                if (file.exists()) {
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
                    }
                    o.close();
                    f.close();
                }
                Thread.sleep(400);
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void save(String change, Object object) {
        try {
            FileOutputStream f = new FileOutputStream(new File("Database.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.write(MainClass.mainClass.managers.size());
            for (Manager manager : MainClass.mainClass.managers)
                o.writeObject(manager);
            o.write(MainClass.mainClass.students.size());
            for (Student student : MainClass.mainClass.students)
                o.writeObject(student);
            o.close();
            f.close();
            File file = new File("NewSave.txt");
            f = new FileOutputStream(file);
            o = new ObjectOutputStream(f);
            o.writeObject(change);
            o.writeObject(object);
            o.close();
            f.close();
            Thread.sleep(800);
            file.delete();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

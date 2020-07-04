package back;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {
    static private ArrayList<User> users = new ArrayList<>();
    private String firstname;
    private String lastname;
    private String username;
    private String password;


    public User(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        users.add(this);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static User getUser(String username) {
        for (User user : users)
            if (user.getUsername().toUpperCase().equals(username.toUpperCase()))
                return user;
        return null;
    }
}

package EXAM.data;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String role;

    public User() {}

    public User(Long id, String login, String password, String name, String surname, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public User(Long id, String login, String name, String surname) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String toString(){
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

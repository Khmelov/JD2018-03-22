package by.it.desykevich.project.java.beans;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private int id;
    private String login, password, email, nickname, phonenumber;
    private int roles_id;

    public User(int id, String login,String password , String email, String nickname, String phonenumber, int roles_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.phonenumber = phonenumber;
        this.roles_id = roles_id;
    }

    public User() {
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_ID(int roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                roles_id == user.roles_id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(phonenumber, user.phonenumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, email, nickname, phonenumber, roles_id);
    }
}
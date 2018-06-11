package by.it.lyukovich.jd_03_03.beans;

import java.sql.Timestamp;

public class User {
    private int userid;
    private String email;
    private String username;
    private String password;
    private Long regdate;
    private String firstname;
    private String secondname;
    private int roleid;

    public User(){
    }

    public User(int userid, String email, String username, String password, Long regdate, String firstname,
                String secondname, int roleid){
        this.userid = userid;
        this.email = email;
        this.username = username;
        this.password = password;
        this.regdate = regdate;
        this.firstname = firstname;
        this.secondname = secondname;
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regdate=" + regdate +
                ", firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", roleid=" + roleid +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRegdate() {
        return regdate;
    }

    public void setRegdate(Long regdate) {
        this.regdate = regdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
}

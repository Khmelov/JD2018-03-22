package by.it.uskoryaev.project.java.beans;

public class User {
    private int user_id;
    private String nick_Name;
    private String email;
    private String password;
    private String first_Name;
    private String last_Name;
    private String middle_Name;
    private String phone_Number;
    private int base_face_id;

    public User() {
    }


    public User(int user_id, String nick_Name, String email, String password, String first_Name, String last_Name, String middle_Name, String phone_Number, int base_face_id) {
        this.user_id = user_id;
        this.nick_Name = nick_Name;
        this.email = email;
        this.password = password;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.middle_Name = middle_Name;
        this.phone_Number = phone_Number;
        this.base_face_id = base_face_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNick_Name() {
        return nick_Name;
    }

    public void setNick_Name(String nick_Name) {
        this.nick_Name = nick_Name;
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

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getMiddle_Name() {
        return middle_Name;
    }

    public void setMiddle_Name(String middle_Name) {
        this.middle_Name = middle_Name;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public int getBase_face_id() {
        return base_face_id;
    }

    public void setBase_face_id(int base_face_id) {
        this.base_face_id = base_face_id;
    }

    @Override
    public String toString() {
        return "\nUser{" + "user_id=" + user_id
                + ",nick_name=" + nick_Name + '\''
                + ",email=" + email + '\''
                + ",password=" + password + '\''
                + ",first_name=" + first_Name + '\''
                + ",last_name=" + last_Name + '\''
                + ",middle_name=" + middle_Name + '\''
                + ",phone_number=" + phone_Number + '\''
                + ",base_face_id=" + base_face_id + '\''
                + '}';
    }
}

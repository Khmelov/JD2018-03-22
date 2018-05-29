package by.it.kirova.jd03_02;

public class User {

    private int user_id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String residence_country;
    private String phone_number;

    public User(){

    }

    public User(int user_id, String email, String password, String first_name, String last_name, String middle_name,
                String residence_country, String phone_number) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.residence_country = residence_country;
        this.phone_number = phone_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getResidence_country() {
        return residence_country;
    }

    public String getPhone_number() {
        return phone_number;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setResidence_country(String residence_country) {
        this.residence_country = residence_country;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", residence_country='" + residence_country + '\'' +
                ", phone_number='" + phone_number  +
                '}';
    }
}

package by.it.uskoryaev.project.java.beans;

public class User {
    private int id;
    private String nickName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private int phoneNumber;
    private int baseFaceId;

    public User() {
    }

    public User(int id, String nickName, String email, String password, int BaseFaceId) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.baseFaceId = BaseFaceId;
    }

    public User(int id, String nickName, String email, String password, String firstName, String lastName, String middleName, int phoneNumber, int baseFaceId) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.baseFaceId = baseFaceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBaseFaceId() {
        return baseFaceId;
    }

    public void setBaseFaceId(int baseFaceId) {
        this.baseFaceId = baseFaceId;
    }

    @Override
    public String toString() {
        return "\nUser{" + "id=" + id
                + ",nick_name=" + nickName + '\''
                + ",email=" + email + '\''
                + ",password=" + password + '\''
                + ",first_name=" + firstName + '\''
                + ",last_name=" + lastName + '\''
                + ",middle_name=" + middleName + '\''
                + ",phone_number=" + phoneNumber + '\''
                + ",base_face_id=" + baseFaceId + '\''
                + '}';
    }
}

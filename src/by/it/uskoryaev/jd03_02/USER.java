package by.it.uskoryaev.jd03_02;

public class User {

    private int id;
    private String nickName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private int phoneNumber;
    private int baseFace_id;

    public User() {
    }

    public User(int id, String nickName, String email, String password, String firstName, String lastName, String middleName, int phoneNumber, int baseFace_id) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.baseFace_id = baseFace_id;
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

    public int getBaseFace_id() {
        return baseFace_id;
    }

    public void setBaseFace_id(int baseFace_id) {
        this.baseFace_id = baseFace_id;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", baseFace_id=" + baseFace_id +
                '}';
    }
}
//ready!!!
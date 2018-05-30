package by.it.romankov.jd03_03.beans;

public class People {
    private int id;
    private String name;
    private String email;
    private int telephone;
    private int age;
    private int roles_id;

    public People() {
    }

    public People(int id, String name, String email, int telephone, int age, int roles_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
        this.roles_id = roles_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public String toString() {
        return "\nPeople{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", id=" + id +
                ", age=" + age +
                ", roles_id=" + roles_id +
                '}';
    }
}


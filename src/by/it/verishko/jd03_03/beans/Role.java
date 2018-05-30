package by.it.verishko.jd03_03.beans;

public class Role {
    public Role() {
    }

    private int id;

    private String role;

    @Override
    public String toString() {
        return "\nRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public void setId() {
//    }
}

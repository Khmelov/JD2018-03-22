package by.it.kirova.jd03_02;

public class RHU {

    private int role_role_id;
    private int users_user_id;

    public RHU(){

    }

    public RHU(int role_role_id, int users_user_id) {
        this.role_role_id = role_role_id;
        this.users_user_id = users_user_id;
    }

    public int getRole_role_id() {
        return role_role_id;
    }

    public int getUsers_user_id() {
        return users_user_id;
    }

    public void setRole_role_id(int role_role_id) {
        this.role_role_id = role_role_id;
    }

    public void setUsers_user_id(int users_user_id) {
        this.users_user_id = users_user_id;
    }

    @Override
    public String toString() {
        return "RHU{" +
                "role_role_id=" + role_role_id +
                ", users_user_id=" + users_user_id +
                '}';
    }
}

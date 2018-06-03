package by.it.danilevich.jd03_03.beans;

import java.io.Serializable;
import java.util.Objects;

public class UserBean implements Serializable {
    private int id;
    private String name;
    private int roleId;
    private String address;
    private String telephone;
    private String login;
    private String password;

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public UserBean() {
    }

    public UserBean(int id, String name, int roleId, String address, String telephone, String login, String password) {
        this.id = id;
        this.name = name;
        this.roleId = roleId;
        this.address = address;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBean userBean = (UserBean) o;
        return id == userBean.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
}

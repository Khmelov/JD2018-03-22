package by.it.danilevich.jd03_03.beans;

import java.io.Serializable;
import java.util.Objects;

public class RoleBean implements Serializable {
    private String name;
    private int id;

    public RoleBean() {
    }

    public RoleBean(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleBean roleBean = (RoleBean) o;
        return Objects.equals(name, roleBean.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

package by.it.danilevich.project.java.beans;

import java.io.Serializable;
import java.util.Objects;

public class KindOfWorkBean implements Serializable {
    private int id;
    private String name;
    private double price;
    private double timeNorm;
    private String category;
    private String unit;

    public KindOfWorkBean(int id, String name, double price, double timeNorm, String category, String unit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.timeNorm = timeNorm;
        this.category = category;
        this.unit = unit;
    }

    public KindOfWorkBean() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTimeNorm() {
        return timeNorm;
    }

    public void setTimeNorm(double timeNorm) {
        this.timeNorm = timeNorm;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "KindOfWorkBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", timeNorm=" + timeNorm +
                ", category='" + category + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KindOfWorkBean that = (KindOfWorkBean) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

package by.it.desykevich.jd03_02.beans;

import java.io.Serializable;
import java.util.Objects;

public class Ad implements Serializable {

    private int id;
    private String title, description;
    private int price;
    private int users_id, category_id;

    public Ad(int id, String title, String description, int price, int users_id, int category_id) {
        this.id = id;
        title = title;
        description = description;
        price = price;
        this.users_id = users_id;
        this.category_id = category_id;
    }

    public Ad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        price = price;
    }

    public int getUsers_Id() {
        return users_id;
    }

    public void setUsers_Id(int users_id) {
        this.users_id = users_id;
    }

    public int getCategory_Id() {
        return category_id;
    }

    public void setCategory_Id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return id == ad.id &&
                Double.compare(ad.price, price) == 0 &&
                users_id == ad.users_id &&
                category_id == ad.category_id &&
                Objects.equals(title, ad.title) &&
                Objects.equals(description, ad.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, description, price, users_id, category_id);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", users_id=" + users_id +
                ", category_id=" + category_id +
                '}';
    }
}
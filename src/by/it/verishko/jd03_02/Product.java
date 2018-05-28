package by.it.verishko.jd03_02;

public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private int users_id;

    public Product() {
    }

    public Product(int id, String name, String description, double price, int users_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.users_id = users_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", users_id=" + users_id +
                '}';
    }
}
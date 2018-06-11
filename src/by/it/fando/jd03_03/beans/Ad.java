package by.it.fando.jd03_03.beans;

public class Ad {

    private int id;
    private String description;
    private int rooms;
    private double price;
    private double area;
    private int flat;
    private int flats;
    private String address;
    private int users_id;

    public Ad() {
    }

    public Ad(int id, String description, int rooms, double price, double area, int flat, int flats, String address, int users_id) {
        this.id = id;
        this.description = description;
        this.rooms = rooms;
        this.price = price;
        this.area = area;
        this.flat = flat;
        this.flats = flats;
        this.address = address;
        this.users_id = users_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getFlats() {
        return flats;
    }

    public void setFlats(int flats) {
        this.flats = flats;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "\nAd{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", rooms=" + rooms +
                ", price=" + price +
                ", area=" + area +
                ", flat=" + flat +
                ", flats=" + flats +
                ", address='" + address + '\'' +
                ", users_id=" + users_id +
                '}';
    }
}

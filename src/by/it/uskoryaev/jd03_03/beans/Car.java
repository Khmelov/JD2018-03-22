package by.it.uskoryaev.jd03_03.beans;

public class Car {
    private int id;
    private String serialNumber;
    private String brand;
    private String model;
    private String bodyCar;
    private String yearRelease;
    private String color;
    private int userId;

    public Car() {
    }

    public Car(int id, String serialNumber, String brand, String model, String bodyCar, String yearRelease, String color, int userId) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.model = model;
        this.bodyCar = bodyCar;
        this.yearRelease = yearRelease;
        this.color = color;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyCar() {
        return bodyCar;
    }

    public void setBodyCar(String bodyCar) {
        this.bodyCar = bodyCar;
    }

    public String getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "\nCar{" + "id=" + id
                + ",serial_number=" + serialNumber + '\''
                + ",brand=" + brand + '\''
                + ",model=" + model + '\''
                + ",body_car=" + bodyCar + '\''
                + ",year_release=" + yearRelease + '\''
                + ",color=" + color + '\''
                + ",user_id=" + userId + '\''
                + '}';
    }
}

package by.it.uskoryaev.project.java.beans;

public class Car {
    private int id_car;
    private String serial_Number;
    private String brand;
    private String model;
    private String body_Car;
    private String year_Release;
    private String color;
    private int user_user_Id;

    public Car() {
    }

    public Car(int id_car, String serial_Number, String brand, String model, String body_Car, String year_Release, String color, int user_user_Id) {
        this.id_car = id_car;
        this.serial_Number = serial_Number;
        this.brand = brand;
        this.model = model;
        this.body_Car = body_Car;
        this.year_Release = year_Release;
        this.color = color;
        this.user_user_Id = user_user_Id;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public String getSerial_Number() {
        return serial_Number;
    }

    public void setSerial_Number(String serial_Number) {
        this.serial_Number = serial_Number;
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

    public String getBody_Car() {
        return body_Car;
    }

    public void setBody_Car(String body_Car) {
        this.body_Car = body_Car;
    }

    public String getYear_Release() {
        return year_Release;
    }

    public void setYear_Release(String year_Release) {
        this.year_Release = year_Release;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getUser_user_Id() {
        return user_user_Id;
    }

    public void setUser_user_Id(int user_user_Id) {
        this.user_user_Id = user_user_Id;
    }

    @Override
    public String toString() {
        return "\nCar{" + "id_car=" + id_car
                + ",serial_number=" + serial_Number + '\''
                + ",brand=" + brand + '\''
                + ",model=" + model + '\''
                + ",body_car=" + body_Car + '\''
                + ",year_release=" + year_Release + '\''
                + ",color=" + color + '\''
                + ",user_id=" + user_user_Id + '\''
                + '}';
    }
}

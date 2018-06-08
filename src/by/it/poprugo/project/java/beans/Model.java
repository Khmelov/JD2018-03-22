package by.it.poprugo.project.java.beans;

public class Model {
    private long id;
    private String model;
    private String name;
    private String address;
    private String phone;
    private String number;
    private String datacontr;
    private int price;
    private int keymoney;
    private int users_idus;

    public Model() {
    }

    public Model(long id, String model, String name, String address, String phone, String number, String datacontr, int price, int keymoney, int users_idus) {
        this.id = id;
        this.model = model;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.number = number;
        this.datacontr = datacontr;
        this.price = price;
        this.keymoney = keymoney;
        this.users_idus = users_idus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDatacontr() {
        return datacontr;
    }

    public void setDatacontr(String datacontr) {
        this.datacontr = datacontr;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKeymoney() {
        return keymoney;
    }

    public void setKeymoney(int keymoney) {
        this.keymoney = keymoney;
    }

    public int getUsers_idus() {
        return users_idus;
    }

    public void setUsers_idus(int users_idus) {
        this.users_idus = users_idus;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", number='" + number + '\'' +
                ", datacontr='" + datacontr + '\'' +
                ", price=" + price +
                ", keymoney=" + keymoney +
                ", users_idus=" + users_idus +
                '}';
    }
}

package by.it.kirova.project.java.beans;

public class Room {

    private int room_id;
    private String room_name;
    private String room_fact_number;
    private int people_amount;
    private String description;
    private double cost;
    private int hotel_hotel_id;


    public Room() {
    }

    public Room(int room_id, String room_name, String room_fact_number, int people_amount,
                String description, double cost, int hotel_hotel_id) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.room_fact_number = room_fact_number;
        this.people_amount = people_amount;
        this.description = description;
        this.cost = cost;
        this.hotel_hotel_id = hotel_hotel_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public String getRoom_fact_number() {
        return room_fact_number;
    }

    public int getPeople_amount() {
        return people_amount;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getHotel_hotel_id() {
        return hotel_hotel_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public void setRoom_fact_number(String room_fact_number) {
        this.room_fact_number = room_fact_number;
    }

    public void setPeople_amount(int people_amount) {
        this.people_amount = people_amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setHotel_hotel_id(int hotel_hotel_id) {
        this.hotel_hotel_id = hotel_hotel_id;
    }

    @Override
    public String toString() {
        return "\nRoom{" +
                "room_id=" + room_id +
                ", room_name='" + room_name + '\'' +
                ", room_fact_number='" + room_fact_number + '\'' +
                ", people_amount=" + people_amount +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", hotel_hotel_id=" + hotel_hotel_id +
                '}';
    }
}

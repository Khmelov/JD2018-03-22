package by.it.kirova.jd03_03.beans;

public class Hotel {

    private int hotel_id;
    private String hotel_name;
    private String hotel_type;
    private int star_rating;
    private String country;
    private String city;
    private String street;
    private String house_number;
    private String contact_email;
    private String contact_phone_number;
    private int user_user_id;

    public Hotel(){

    }

    public Hotel(int hotel_id, String hotel_name, String hotel_type, int star_rating, String country,
                 String city, String street, String house_number, String contact_email, String contact_phone_number,
                 int user_user_id) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_type = hotel_type;
        this.star_rating = star_rating;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.contact_email = contact_email;
        this.contact_phone_number = contact_phone_number;
        this.user_user_id = user_user_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public String getHotel_type() {
        return hotel_type;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse_number() {
        return house_number;
    }

    public String getContact_email() {
        return contact_email;
    }

    public String getContact_phone_number() {
        return contact_phone_number;
    }

    public int getUser_user_id() {
        return user_user_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public void setHotel_type(String hotel_type) {
        this.hotel_type = hotel_type;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = star_rating;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public void setContact_phone_number(String contact_phone_number) {
        this.contact_phone_number = contact_phone_number;
    }

    public void setUser_user_id(int user_user_id) {
        this.user_user_id = user_user_id;
    }

    @Override
    public String toString() {
        return "\nHotel{" +
                "hotel_id=" + hotel_id +
                ", hotel_name='" + hotel_name + '\'' +
                ", hotel_type='" + hotel_type + '\'' +
                ", star_rating=" + star_rating +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house_number='" + house_number + '\'' +
                ", contact_email='" + contact_email + '\'' +
                ", contact_phone_number='" + contact_phone_number + '\'' +
                ", user_user_id=" + user_user_id +
                '}';
    }
}

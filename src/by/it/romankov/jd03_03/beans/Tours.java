package by.it.romankov.jd03_03.beans;

 public class Tours {
     private int id;
    private String target;
    private String transport;
    private String country;
    private  String city;
    private int days;
    private int price;
    private int people_id;

public Tours(){}

    public Tours(int id, String target, String transport, String country, String city, int days, int price,  int people_id) {
       this.target = target;
       this.transport = transport;
       this.country = country;
       this.city = city;
       this.days = days;
       this.price = price;
       this.id = id;
       this.people_id = people_id;
    }

    public String getTarget() {
       return target;
    }

    public void setTarget(String target) {
       this.target = target;
    }

    public String getTransport() {
       return transport;
    }

    public void setTransport(String transport) {
       this.transport = transport;
    }

    public String getCountry() {
       return country;
    }

    public void setCountry(String country) {
       this.country = country;
    }

    public String getCity() {
       return city;
    }

    public void setCity(String city) {
       this.city = city;
    }

    public int getDays() {
       return days;
    }

    public void setDays(int days) {
       this.days = days;
    }

    public int getPrice() {
       return price;
    }

    public void setPrice(int price) {
       this.price = price;
    }

    public int getId() {
       return id;
    }

    public void setId(int id) {
       this.id = id;
    }

    public int getPeople_id() {
       return people_id;
    }

    public void setPeople_id(int people_id) {
       this.people_id = people_id;
    }

     @Override
     public String toString() {
         return "\nTours{" +
                 "id=" + id +
                 ", target='" + target + '\'' +
                 ", transport='" + transport + '\'' +
                 ", country='" + country + '\'' +
                 ", city='" + city + '\'' +
                 ", days=" + days +
                 ", price=" + price +
                 ", people_id=" + people_id +
                 '}';
     }
 }


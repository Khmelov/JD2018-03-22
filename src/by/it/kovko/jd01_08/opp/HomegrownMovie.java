package by.it.kovko.jd01_08.opp;

public abstract class HomegrownMovie implements Movie{

    public void rate(int r){
        System.out.println("Рейтинг "+ r+ " вышел за пределы от 0 до 10");
    }
    HomegrownMovie(String name){
        this.name=name;
    }
    public String getOriginCountry() {
        return "Homeland";
    }

    public String getLanguage() {
        return "Homelanguage";
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public boolean isViewed() {
        return viewed;
    }

    double price;
    int id, rating;
    protected String comment="", genre, name;
    protected boolean viewed;

}

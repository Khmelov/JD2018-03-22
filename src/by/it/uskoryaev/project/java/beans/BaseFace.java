package by.it.uskoryaev.project.java.beans;

public class BaseFace {
    private int id;
    private String baseFace;

    public BaseFace() {
    }

    public BaseFace(int id, String baseFace) {
        this.id = id;
        this.baseFace = baseFace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaseFace() {
        return baseFace;
    }

    public void setBaseFace(String baseFace) {
        this.baseFace = baseFace;
    }

    @Override
    public String toString() {
        return "\nBaseFace{" + "id=" + id + ",base_face=" + baseFace + '\'' + '}';
    }
}

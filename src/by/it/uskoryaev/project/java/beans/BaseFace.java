package by.it.uskoryaev.project.java.beans;

public class BaseFace {
    private int id;
    private String base_Face;

    public BaseFace() {
    }

    public BaseFace(int id, String base_Face) {
        this.id = id;
        this.base_Face = base_Face;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBase_Face() {
        return base_Face;
    }

    public void setBase_Face(String base_Face) {
        this.base_Face = base_Face;
    }

    @Override
    public String toString() {
        return "\nBaseFace{" + "id=" + id + ",base_face=" + base_Face + '\'' + '}';
    }
}

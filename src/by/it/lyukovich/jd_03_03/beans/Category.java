package by.it.lyukovich.jd_03_03.beans;

public class Category {
    private int categoryid;
    private int categorysubid;
    private String categoryname;
    private String categorydescription;

    public Category(){

    }

    public Category(int categoryid, int categorysubid, String categoryname, String categorydescription) {
        this.categoryid = categoryid;
        this.categorysubid = categorysubid;
        this.categoryname = categoryname;
        this.categorydescription = categorydescription;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryid=" + categoryid +
                ", categorysubid=" + categorysubid +
                ", categoryname='" + categoryname + '\'' +
                ", categorydescription='" + categorydescription + '\'' +
                '}';
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getCategorysubid() {
        return categorysubid;
    }

    public void setCategorysubid(int categorysubid) {
        this.categorysubid = categorysubid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCategorydescription() {
        return categorydescription;
    }

    public void setCategorydescription(String categorydescription) {
        this.categorydescription = categorydescription;
    }
}

package by.it.romankov.jd03_02;

 class Roles {
    private String role;
    private int id;

    public Roles(){}

     public Roles(String role, int id) {
         this.role = role;
         this.id = id;
     }

     public void setRole(String role) {
         this.role = role;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getRole() {
         return role;
     }

     public int getId() {
         return id;
     }

     @Override
     public String toString() {
         return "Roles{" +
                 "role='" + role + '\'' +
                 ", id=" + id +
                 '}';
     }
 }

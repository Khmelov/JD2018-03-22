package by.it.romankov.project.java.beans;

 public class Roles {
     private int id;
     private String role;


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
         return "\nRoles{" +
                 "role='" + role + '\'' +
                 ", id=" + id +
                 '}';
     }
 }

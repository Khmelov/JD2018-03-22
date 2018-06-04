package by.it.desykevich.project.java.controller;

public interface Patterns {
    String LOGIN = "[a-zA-Z0-9]{5,20}";
    String EMAIL = "[a-zA-Z0-9.-_ ]+@[a-zA-Z0-9.-_ ]+\\.[a-zA-Z0-9.-_ ]+";
    String PASSWORD  = "[a-zA-Z0-9]{5,20}";
    String NICKNAME  = "[a-zA-Z0-9]{5,20}";
    String PHONENUMBER = "[\\+]+[0-9]{12}";
}

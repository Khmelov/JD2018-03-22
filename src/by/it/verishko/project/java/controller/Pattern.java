package by.it.verishko.project.java.controller;

public interface Pattern {
    String LOGIN = "([\\w]{6,12})";
    String EMAIL = "([\\w\\.\\w]+)@(\\w+\\.)([a-z]{2,4})";
    String PASSWORD = "([\\w]{6,12})";
}
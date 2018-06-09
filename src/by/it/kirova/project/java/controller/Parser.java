package by.it.kirova.project.java.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static boolean validator(String parameter, String name) {
        boolean statement = false;
        String reg = "";
        switch (name) {
            case "email":
                reg = "([\\w\\.\\w]+)@(\\w+\\.)([a-z]{2,4})";
                return reg(reg, parameter);
            case "password":
                reg = "([\\w]{5,15})";
                return reg(reg, parameter);
            case "firstname":
                reg = "([A-Za-zА-Яа-яЁё]+)";
                return reg(reg, parameter);
            case "lastname":
                reg = "([A-Za-zА-Яа-яЁё]+)";
                return reg(reg, parameter);
            case "middlename":
                reg = "([A-Za-zА-Яа-яЁё]*)";
                return reg(reg, parameter);
            case "residencecountry":
                reg = "([А-Яа-яЁёA-Za-z]+)([ -])?([А-Яа-яЁёA-Za-z]*)([ -])?([А-Яа-яЁёA-Za-z]*)";
                return reg(reg, parameter);
            case "phonenumber":
                reg = "([+]([0-9]+)([ ])([0-9]{7}))";
                return reg(reg, parameter);
            case "hotelname":
                reg = "([A-Za-zА-Яа-яЁё0-9 &]+)";
                return reg(reg, parameter);
            case "hoteltype":
                reg = "([A-Za-zА-Яа-яЁё]+)";
                return reg(reg, parameter);
            case "starrating":
                reg = "([1-5]?)";
                return reg(reg, parameter);
            case "country":
                reg = "([А-Яа-яЁёA-Za-z]+)([ -])?([А-Яа-яЁёA-Za-z]*)([ -])?([А-Яа-яЁёA-Za-z]*)";
                return reg(reg, parameter);
            case "city":
                reg = "([А-Яа-яЁёA-Za-z]+)([ -])?([А-Яа-яЁёA-Za-z]*)([ -])?([А-Яа-яЁёA-Za-z]*)";
                return reg(reg, parameter);
            case "street":
                reg = "([А-Яа-яЁёA-Za-z]+)([ -])?([А-Яа-яЁёA-Za-z]*)([ -])?([А-Яа-яЁёA-Za-z]*)";
                return reg(reg, parameter);
            case "housenumber":
                reg = "([A-Za-zА-Яа-яЁё0-9 ]+)";
                return reg(reg, parameter);
            case "contactphone":
                reg = "([+]([0-9]+)([ ])([0-9]{7}))";
                return reg(reg, parameter);
            case "roomname":
                reg = "([A-Za-zА-Яа-яЁё0-9 ]+)";
                return reg(reg, parameter);
            case "roomfactnumber":
                reg = "([A-Za-zА-Яа-яЁё0-9]*)";
                return reg(reg, parameter);
            case "description":
                reg = "([A-Za-zА-Яа-яЁё0-9 ]*)";
                return reg(reg, parameter);
            case "peopleamount":
                reg = "([1-5]{1})";
                return reg(reg, parameter);
            case "cost":
                reg = "([0-9]{1,5})([\\.])([0-9]{0,3})";
                return reg(reg, parameter);
            case "date":
                reg = "([0-9]{2})([\\.])([0-9]{2})([\\.])([0-9]{4})";
                return reg(reg, parameter);
            default:
                break;
        }
        return statement;
    }


    public static boolean reg(String regex, String parameter) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(parameter);
        return !m.find();
    }
}

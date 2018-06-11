package by.it.danilevich.project.java.dao.connect;

import java.util.Arrays;
import java.util.List;

public class CN {
    public static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/"+ 
            "?useUnicode=true&characterEncoding=UTF-8";
    public static final String NAME_DB = "danilevich";
    public static final String USER_DB = "root";
    public static final String PASSWORD_DB = "";

    public static List<String> listCategory = Arrays.asList(new String[]{"Electro", "Water pipes","Repairs"});
    public static List<String> listStatus = Arrays.asList(new String[]{"Waiting", "In process","Close"});
    ;
    public static List<String> listUnit = Arrays.asList(new String[]{"thing", "m","m2"});
    ;


}

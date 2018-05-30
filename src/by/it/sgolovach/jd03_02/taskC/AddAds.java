package by.it.sgolovach.jd03_02.taskC;

import by.it.sgolovach.jd03_02.beans.Ad;
import by.it.sgolovach.jd03_02.crud.AdCRUD;

import java.sql.SQLException;

public class AddAds {
    public static void main(String[] args) throws SQLException {

        Ad ad = new Ad(-1, "good flat", 3, 13699.1, 32.5, 1, 2, "Minsk, Brikete 2", 3);
        AdCRUD.create(ad);
        ad = new Ad(-1, "buy flat", 8, 252635.9, 168.9, 25, 25, "Moscow, Sgukova 1", 1);
        AdCRUD.create(ad);
        ad = new Ad(-1, "good flat", 2, 25000.0, 15, 1, 2, "Gomel, Brikete 8", 2);
        AdCRUD.create(ad);
        ad = new Ad(-1, "buy flat in Minsk,Grodno", 3, 63000.0, 89.0, 2, 9, "Minsk,Grodno", 5);
        AdCRUD.create(ad);
        ad = new Ad(-1, "good flat", 3, 35450.0, 92.5, 5, 5, "Mogilev, Lomonosova 26", 4);
        AdCRUD.create(ad);
        ad = new Ad(-1, "good flat", 2, 27893.0, 76.0, 2, 5, "Mogilev, Lenina 15", 4);
        AdCRUD.create(ad);
        ad = new Ad(-1, "buy flat in Minsk", 6, 95635.0, 127.9, 3, 5, "Minsk, Pobediteley 13", 6);
        AdCRUD.create(ad);
        ad = new Ad(-1, "good flat", 2, 95635.0, 56.0, 7, 9, "Minsk, Filimonova 35", 3);
        AdCRUD.create(ad);
        ad = new Ad(-1, "good flat in Varshava Poland", 3, 38956.0, 68.0, 4, 5, "Varshava, Kastushki 92", 2);
        AdCRUD.create(ad);
        ad = new Ad(-1, "good flat in London UK", 4, 136958.0, 127.0, 29, 35, "London, Picadili 6/2", 4);
        AdCRUD.create(ad);
        ad = new Ad(-1, "good flat", 5, 35689.0, 125.0, 2, 5, "Vitebsk, Chepelia 39", 2);
        AdCRUD.create(ad);
        ad = new Ad(-1, "good flat", 3, 29853.0, 98.0, 7, 10, "Minsk, Suharevo 85", 3);
        AdCRUD.create(ad);

    }
}

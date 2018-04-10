package by.it.kovko.jd01_08.opp;

public interface Movie {
    void rate(int r);
    void buy();
    void rent(int days);
    void comment(String com);
    void recommend(int userId);
    void markAsViewed();
    void adToWishList();

}

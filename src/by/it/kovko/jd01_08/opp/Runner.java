package by.it.kovko.jd01_08.opp;

public class Runner {
    public static void main(String[] args) {
        ComedyMovie movie = new ComedyMovie("Иван Васильевич меняет профессию");
        movie.setPrice(32.34);
        movie.setId(4546786);



        movie.comment("Отичный фильм");
        movie.comment("Отличный фильм 2");
        movie.rate(13);
        movie.rate(8);

        System.out.println(movie.getGenre());
        System.out.println(movie.toString());
        System.out.println(movie.getRating());
        System.out.println(movie.getComment());
        movie.rent(3);
        movie.recommend(233242);
        System.out.print("Фильм просмотрен: ");
        movie.markAsViewed();
        System.out.println(movie.isViewed());
        movie.adToWishList();

        movie.buy();
        movie.buy(123123);
    }
}

package by.it.kovko.jd01_08.opp;

public class ComedyMovie extends HomegrownMovie{

    ComedyMovie(String name) {
        super(name);
    }

    @Override
    public void rate(int r) {
        if (r<=10 && r>=0)
            rating=r;
        else
            super.rate(r);
    }

    @Override
    public void buy() {
        System.out.println(price+" будет списано с вашего счета");
    }


    public void buy(int depositNumber) {
        System.out.println(price+" будет списано со счета " + depositNumber);
    }

    @Override
    public void rent(int days) {
        System.out.println("Взять фильм на прокат на "+ days +" дней");
    }

    @Override
    public void comment(String com) {
        comment+=(com+"\n");
    }

    @Override
    public void recommend(int userId) {
        System.out.println("Отправляет рекомендацию на просмотр пользователю с ID" +userId);
    }


    @Override
    public void markAsViewed() {
        viewed=true;
    }

    @Override
    public void adToWishList() {
        System.out.println("Фильм \"" + this.toString() + "\" добавлен в список покупок");
    }


    @Override
    public String getGenre() {
        return "Comedy";
    }
}

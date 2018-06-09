package by.it.kirova.project.java.beans;

public class Reservation {

    private int reservation_id;
    private long reservation_date;
    private long check_in_date;
    private long check_out_date;
    private double total_cost;
    private int room_room_id;
    private int user_user_id;

    public Reservation() {
    }

    public Reservation(int reservation_id, long reservation_date, long check_in_date, long check_out_date,
                       double total_cost, int room_room_id, int user_user_id) {
        this.reservation_id = reservation_id;
        this.reservation_date = reservation_date;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.total_cost = total_cost;
        this.room_room_id = room_room_id;
        this.user_user_id = user_user_id;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public long getReservation_date() {
        return reservation_date;
    }

    public long getCheck_in_date() {
        return check_in_date;
    }

    public long getCheck_out_date() {
        return check_out_date;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public int getRoom_room_id() {
        return room_room_id;
    }

    public int getUser_user_id() {
        return user_user_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public void setReservation_date(long reservation_date) {
        this.reservation_date = reservation_date;
    }

    public void setCheck_in_date(long check_in_date) {
        this.check_in_date = check_in_date;
    }

    public void setCheck_out_date(long check_out_date) {
        this.check_out_date = check_out_date;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public void setRoom_room_id(int room_room_id) {
        this.room_room_id = room_room_id;
    }

    public void setUser_user_id(int user_user_id) {
        this.user_user_id = user_user_id;
    }

    @Override
    public String toString() {
        return "\nReservation{" +
                "reservation_id=" + reservation_id +
                ", reservation_date=" + reservation_date +
                ", check_in_date=" + check_in_date +
                ", check_out_date=" + check_out_date +
                ", total_cost=" + total_cost +
                ", room_room_id=" + room_room_id +
                ", user_user_id=" + user_user_id +
                '}';
    }
}

package by.it.kirova.jd01_08.oop;

public class AircraftCarrier extends Warship {

    private boolean usePlainsForSearch;
    private boolean plainsOnBoard = true;

//    public boolean isUsePlainsForSearch() {
//        return usePlainsForSearch;
//    }

    public void setUsePlainsForSearch(boolean usePlainsForSearch) {
        this.usePlainsForSearch = usePlainsForSearch;
    }

    public AircraftCarrier(double x, double y, boolean usePlainsForSearch) {
        super(x, y);
        this.usePlainsForSearch = usePlainsForSearch;
    }

    private void plainsUp() {
        plainsOnBoard = false;
        System.out.println("Самолеты подняты.");
    }

    private void plainsDown() {
        plainsOnBoard = true;
        System.out.println("Самолеты вернулись.");
    }

    private void plainsAttack() {
        System.out.println("Атака самолетами...");
    }

    @Override
    protected void attack() {
        if (plainsOnBoard)
            plainsUp();
        plainsAttack();
        plainsDown();
    }

    @Override
    public void patrol(int time) {
        if (usePlainsForSearch) {
            plainsUp();
        }
        super.patrol(time);
    }

    @Override
    protected int getScanQualityForPatrol() {
        int sqp = super.getScanQualityForPatrol();
        if (usePlainsForSearch)
            sqp *= 2;
        return sqp;
    }
}

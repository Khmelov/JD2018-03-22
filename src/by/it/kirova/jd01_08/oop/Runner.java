package by.it.kirova.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        AircraftCarrier admPotemkin = new AircraftCarrier(0,0, false);
        System.out.println("Патрулирование 1:\n");
        admPotemkin.patrol(20);
        System.out.println("\nПатрулирование 2:\n");
        admPotemkin.setUsePlainsForSearch(true);
        admPotemkin.patrol(20);
        System.out.println("\nАтака заданного противника:\n");
        AircraftCarrier enemy = new AircraftCarrier(5, 8, false);
        admPotemkin.attack(enemy);
    }
}

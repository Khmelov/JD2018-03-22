package by.it.kirova.jd01_08.oop;

public abstract class Warship implements IShip {

    private double x;
    private double y;

    Warship(double x, double y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean moveOnVector(double dx, double dy) {
        System.out.println("Перемещаюсь...");
        this.x = x + dx;
        this.y = y + dy;
        if (x == 13 || y == 13) {
            System.out.println("Мы сели на мель... =(");
            return false;
        }
        return true;

    }

    private static boolean scanForEnemy(int quality) {
        System.out.println("Сканирую...");
        return (Math.random() * 100) < quality;
    }

    public void patrol(int time) {
        int sq = getScanQualityForPatrol();
        System.out.println("Радиус сканирования " + sq + ".");
        for (int i = 0; i < time; i++) {
            if (scanForEnemy(sq)) {
                System.out.println("Враг обнаружен!");
                attack();
                System.out.println("Враг уничтожен на " + (i + 1) + " ходу!!!");
                return;
            }
            if (!moveOnVector(1, 1))
                return;
        }
        System.out.println("Враг не обнаружен!");
    }

    protected int getScanQualityForPatrol() {
        return 7;
    }

    protected abstract void attack();
}

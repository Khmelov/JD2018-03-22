package by.it.uskoryaev.jd01_08.oop;

class SimensMobile extends Model implements Mobile {
    @Override
    public boolean off() {
        return false;
    }

    @Override
    public boolean on() {
        return false;
    }

    @Override
    public int levelVolume() {
        return 0;
    }

    @Override
    public int zvonok() {
        return 0;
    }

    @Override
    void playMusic() {
        super.playMusic();
    }

    @Override
    void showPichers() {
        super.showPichers();
    }

    @Override
    void onFonar() {
        super.onFonar();
    }
}

package by.it.uskoryaev.jd02_01;

class Util {
    static void sleep(int msTimeOut){
        try {
            Thread.sleep(msTimeOut);
        }catch (InterruptedException e){
            e.getStackTrace();
        }
    }
    static int random(int from,int to){
        return from+(int) Math.random()*(1+to-from);
    }
    static int random(){ return random(0, 2);
    }
}


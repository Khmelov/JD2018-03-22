package by.it._examples_.jd02_06.p07_facade.objects;

import by.it._examples_.jd02_06.p07_facade.facade.CarFacade;
import by.it._examples_.jd02_06.p07_facade.parts.Door;
import by.it._examples_.jd02_06.p07_facade.parts.Wheel;
import by.it._examples_.jd02_06.p07_facade.parts.Clamping;

public class Client {

    public static void main(String[] args) {
        // вызов без фасада
        Door door = new Door();
        door.open();

        Clamping clamping = new Clamping();
        clamping.fire();
        
        Wheel wheel = new Wheel();
        wheel.turn();
        

        // вызов с фасадом
        CarFacade carFacade = new CarFacade();
        carFacade.go();
    }
}

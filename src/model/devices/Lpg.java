package model.devices;

public class Lpg extends Car {
    public Lpg(String producer, String model) {
        super(producer, model);
    }

    @Override
    public void refuel() {
        System.out.println("Zatankowano LPG!");
    }
}

package model.devices;

public class Diesel extends Car {
    public Diesel(String producer, String model) {
        super(producer, model);
    }

    @Override
    public void refuel() {
        System.out.println("Zatankowano Olej napędowy!");
    }
}

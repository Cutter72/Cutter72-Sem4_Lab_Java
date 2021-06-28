package model.devices;

public class Electric extends Car {
    public Electric(String producer, String model) {
        super(producer, model);
    }

    @Override
    public void refuel() {
        System.out.println("Naładowano baterie!");
    }
}

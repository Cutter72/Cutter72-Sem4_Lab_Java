package model;

public class Car {
    private final String producer;
    private final String model;
    private double horsePower;
    private double value;

    public Car(String producer, String model) {
        this.producer = producer;
        this.model = model;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }
}

package model.devices;

public class Car extends Device {
    private double horsePower;
    private double value;

    public Car(String producer, String model) {
        super(producer, model);
    }

    @Override
    public void turnOn() {
        System.out.println("Samochód włączony!");
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + getProducer() + '\'' +
                ", model='" + getModel() + '\'' +
                ", horsePower=" + horsePower +
                ", value=" + value +
                '}';
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

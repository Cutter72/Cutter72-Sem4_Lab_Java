package model.devices;

import model.Human;
import model.Sellable;

import java.util.Date;
import java.util.Objects;

public abstract class Car extends Device implements Sellable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.horsePower, horsePower) == 0
                && Double.compare(car.value, value) == 0
                && Objects.equals(car.getYearOfProduction(), getYearOfProduction())
                && car.getModel().equals(getModel())
                && car.getProducer().equals(getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, value, getModel(), getProducer(), getYearOfProduction());
    }

    @Override
    public boolean sell(Human seller, Human buyer, Double price) {
        if (seller.equals(buyer)) {
            System.out.printf("%s! Sprzedaż samemu sobie jest bez sensu!%n", buyer.getName());
            return false;
        }
        if (this.equals(seller.getCar())) {
            if (buyer.getCash() >= price) {
                seller.setCash(seller.getCash() + price);
                buyer.setCash(buyer.getCash() - price);
                buyer.setCar(this);
                seller.setCar(null);
                System.out.println("Transakcja zakończona powodzeniem! Szczegóły:");
                System.out.printf("Sprzedano: %s, %s, %dr., %.2fHP za %.2f zł%n",
                        this.getProducer(), this.getModel(), this.getYearOfProduction(), this.getHorsePower(), price);
                System.out.printf("Kupił: %s %s%n", buyer.getName(), buyer.getLastName());
                System.out.printf("Sprzedał: %s %s%n", seller.getName(), seller.getLastName());
                System.out.println("Data transakcji: " + new Date());
                return true;
            } else {
                System.out.printf("Kupiec %s nie ma tyle pieniędzy!%n", buyer.getName());
                return false;
            }
        } else {
            System.out.printf("Sprzedawca %s nie ma takiego samochodu!%n", seller.getName());
            return false;
        }
    }

    public abstract void refuel();
}

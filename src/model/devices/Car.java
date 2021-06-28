package model.devices;

import model.Human;
import model.Sellable;

import java.util.Date;
import java.util.Objects;

public abstract class Car extends Device implements Sellable {
    private Double horsePower;

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
                ", value=" + getValue() +
                '}';
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
                && Double.compare(car.getValue(), getValue()) == 0
                && Objects.equals(car.getYearOfProduction(), getYearOfProduction())
                && car.getModel().equals(getModel())
                && car.getProducer().equals(getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, getValue(), getModel(), getProducer(), getYearOfProduction());
    }

    @Override
    public boolean sell(Human seller, Human buyer, Double price) throws Exception {
        if (seller.equals(buyer)) {
            System.out.printf("%s! Sprzedaż samemu sobie jest bez sensu!%n", buyer.getName());
            return false;
        }
        if (buyer.getCash() < price) {
            throw new Exception(String.format("Kupiec %s nie ma tyle pieniędzy!", buyer.getName()));
        }
        Car[] sellerGarage = seller.getGarage();
        Car[] buyerGarage = buyer.getGarage();
        boolean hasSellerACar = false;
        boolean hasBuyerAnEmptyPlace = false;
        int sellerCarPlace = -1;
        int buyerEmptyPlace = -1;
        for (int i = 0; i < sellerGarage.length; i++) {
            if (this.equals(sellerGarage[i])) {
                hasSellerACar = true;
                sellerCarPlace = i;
            }
        }
        if (!hasSellerACar) {
            throw new Exception("Sprzedawca nie ma tego auta!");
        }
        for (int i = 0; i < buyerGarage.length; i++) {
            if (sellerGarage[i] == null) {
                hasBuyerAnEmptyPlace = true;
                buyerEmptyPlace = i;
            }
        }
        if (!hasBuyerAnEmptyPlace) {
            throw new Exception("Kupiec nie ma miejsca w garażu!");
        }
        executeTransaction(seller, buyer, price, sellerCarPlace, buyerEmptyPlace);
        return true;
    }

    private void executeTransaction(Human seller, Human buyer, Double price, int sellerCarPlace, int buyerEmptyPlace) {
        seller.setCash(seller.getCash() + price);
        buyer.setCash(buyer.getCash() - price);
        buyer.setCar(this, buyerEmptyPlace);
        seller.setCar(null, sellerCarPlace);
        confirmTransaction(seller, buyer, price);
    }

    private void confirmTransaction(Human seller, Human buyer, Double price) {
        System.out.println("Transakcja zakończona powodzeniem! Szczegóły:");
        System.out.printf("Sprzedano: %s, %s, %dr., %.2fHP za %.2f zł%n",
                this.getProducer(), this.getModel(), this.getYearOfProduction(), this.getHorsePower(), price);
        System.out.printf("Kupił: %s %s%n", buyer.getName(), buyer.getLastName());
        System.out.printf("Sprzedał: %s %s%n", seller.getName(), seller.getLastName());
        System.out.println("Data transakcji: " + new Date());
    }

    public abstract void refuel();
}

package model.devices;

import model.Human;
import model.Sellable;

import java.util.Date;
import java.util.Objects;

public class Phone extends Device implements Sellable {
    private String operationSystem;
    private String screenSize;

    @Override
    public void turnOn() {
        System.out.println("Telefon włączony!");
    }

    @Override
    public String toString() {
        return "model.devices.Phone{" +
                "producer='" + getProducer() + '\'' +
                ", model='" + getModel() + '\'' +
                ", operationSystem='" + operationSystem + '\'' +
                ", screenSize='" + screenSize + '\'' +
                '}';
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(operationSystem, phone.operationSystem)
                && Objects.equals(screenSize, phone.screenSize)
                && Objects.equals(phone.getYearOfProduction(), getYearOfProduction())
                && phone.getModel().equals(getModel())
                && phone.getProducer().equals(getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationSystem, screenSize, getModel(), getProducer(), getYearOfProduction());
    }

    @Override
    public boolean sell(Human seller, Human buyer, Double price) {
        if (seller.equals(buyer)) {
            System.out.printf("%s! Sprzedaż samemu sobie jest bez sensu!%n", buyer.getName());
            return false;
        }
        if (this.equals(seller.getPhone())) {
            if (buyer.getCash() >= price) {
                seller.setCash(seller.getCash() + price);
                buyer.setCash(buyer.getCash() - price);
                buyer.setPhone(this);
                seller.setPhone(null);
                System.out.println("Transakcja zakończona powodzeniem! Szczegóły:");
                System.out.printf("Sprzedano: %s, %s, %dr., %s za %.2f zł%n",
                        this.getProducer(), this.getModel(), this.getYearOfProduction(), this.getOperationSystem(), price);
                System.out.printf("Kupił: %s %s%n", buyer.getName(), buyer.getLastName());
                System.out.printf("Sprzedał: %s %s%n", seller.getName(), seller.getLastName());
                System.out.println("Data transakcji: " + new Date());
                return true;
            } else {
                System.out.printf("Kupiec %s nie ma tyle pieniędzy!%n", buyer.getName());
                return false;
            }
        } else {
            System.out.printf("Sprzedawca %s nie ma takiego telefonu!%n", seller.getName());
            return false;
        }
    }
}

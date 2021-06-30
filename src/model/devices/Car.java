package model.devices;

import model.Human;
import model.Sellable;
import model.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Car extends Device implements Sellable {
    private Double horsePower;
    private List<Transaction> transactions;

    public Car(String producer, String model) {
        super(producer, model);
        this.transactions = new ArrayList<>();
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
        Human owner = getOwner();
        if (owner != null) {
            if (!seller.equals(owner)) {
                throw new Exception(String.format("Sprzedawca %s nie jest właścicielem auta! Ostatni właściciel to: %s %s!",
                        seller.getName(), owner.getName(), owner.getLastName()));
            }
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

    private Human getOwner() {
        if (this.transactions.size() > 0) {
            return this.transactions.get(this.transactions.size() - 1).getBuyer();
        }
        return null;
    }

    private void executeTransaction(Human seller, Human buyer, Double price, int sellerCarPlace, int buyerEmptyPlace) {
        seller.setCash(seller.getCash() + price);
        buyer.setCash(buyer.getCash() - price);
        buyer.setCar(this, buyerEmptyPlace);
        seller.setCar(null, sellerCarPlace);
        Date transactionDate = new Date();
        this.transactions.add(new Transaction()
                .setSeller(seller)
                .setBuyer(buyer)
                .setPrice(price)
                .setDate(transactionDate)
        );
        confirmTransaction(seller, buyer, price, transactionDate);
    }

    private void confirmTransaction(Human seller, Human buyer, Double price, Date transactionDate) {
        System.out.println("Transakcja zakończona powodzeniem! Szczegóły:");
        System.out.printf("Sprzedano: %s, %s, %dr., %.2fHP za %.2f zł%n",
                this.getProducer(), this.getModel(), this.getYearOfProduction(), this.getHorsePower(), price);
        System.out.printf("Kupił: %s %s%n", buyer.getName(), buyer.getLastName());
        System.out.printf("Sprzedał: %s %s%n", seller.getName(), seller.getLastName());
        System.out.println("Data transakcji: " + transactionDate);
    }

    public abstract void refuel();

    public boolean wasAnOwner(Human previousOwner) {
        boolean result;
        for (Transaction transaction : this.transactions) {
            result = transaction.getSeller().equals(previousOwner)
                    || transaction.getBuyer().equals(previousOwner);
            if (result) {
                return true;
            }
        }
        return false;
    }

    public boolean didHumanASellThisCarToHumanB(Human a, Human b) {
        boolean result;
        for (Transaction transaction : this.transactions) {
            result = transaction.getSeller().equals(a)
                    && transaction.getBuyer().equals(b);
            if (result) {
                return true;
            }
        }
        return false;
    }

    public int transactionsQuantity() {
        return this.transactions.size();
    }
}

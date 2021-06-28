package model;

public interface Sellable {
    boolean sell(Human seller, Human buyer, Double price) throws Exception;
}

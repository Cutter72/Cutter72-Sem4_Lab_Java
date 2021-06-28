package model.creatures;

import model.Human;
import model.Sellable;

import java.io.File;
import java.util.Date;
import java.util.Objects;

public abstract class Animal implements Sellable, Feedable {
    static final public Double DEFAULT_ANIMAL_WEIGHT = 1.0;
    private final String species;
    private String name;
    private Double weight;
    private File pic;

    public Animal(String species) {
        this.species = species;
        switch (this.species) {
            case "canis":
                this.weight = 15.0;
                break;
            case "feline":
                this.weight = 2.0;
                break;
            default:
                this.weight = DEFAULT_ANIMAL_WEIGHT;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name)
                && Objects.equals(weight, animal.weight)
                && Objects.equals(species, animal.species)
                && Objects.equals(pic, animal.pic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, species, pic);
    }

    public void feed() {
        if (this.weight > 0) {
            this.weight += 0.1;
            System.out.println(name + " is feeded. New weight is: " + this.weight);
        } else {
            System.out.println(name + " is dead!");
        }
    }

    public void takeForAWalk() {
        if (this.weight > 0) {
            this.weight -= 0.1;
            System.out.println(name + " burned some calories. New weight is: " + this.weight);
        } else {
            System.out.println(name + " is dead! To much walk!");
        }
    }

    @Override
    public String toString() {
        return "model.creatures.Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", species='" + species + '\'' +
                ", pic=" + pic +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public File getPic() {
        return pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }

    @Override
    public boolean sell(Human seller, Human buyer, Double price) {
        if (seller.equals(buyer)) {
            System.out.printf("%s! Sprzedaż samemu sobie jest bez sensu!%n", buyer.getName());
            return false;
        }
        if (this.equals(seller.getPet())) {
            if (buyer.getCash() >= price) {
                seller.setCash(seller.getCash() + price);
                buyer.setCash(buyer.getCash() - price);
                buyer.setPet(this);
                seller.setPet(null);
                System.out.println("Transakcja zakończona powodzeniem! Szczegóły:");
                System.out.printf("Sprzedano: %s, %s, %.2f kg za %.2f zł%n",
                        this.name, this.species, this.weight, price);
                System.out.printf("Kupił: %s %s%n", buyer.getName(), buyer.getLastName());
                System.out.printf("Sprzedał: %s %s%n", seller.getName(), seller.getLastName());
                System.out.println("Data transakcji: " + new Date());
                return true;
            } else {
                System.out.printf("Kupiec %s nie ma tyle pieniędzy!%n", buyer.getName());
                return false;
            }
        } else {
            System.out.printf("Sprzedawca %s nie ma takiego zwierzęcia!%n", seller.getName());
            return false;
        }
    }
}

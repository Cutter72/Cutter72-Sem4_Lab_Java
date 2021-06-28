package model.creatures;

public class FarmAnimal extends Animal implements Edible {
    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        System.out.println("Zwierzę zostało zjedzone!");
    }

    @Override
    public void feed(Double foodWeight) {
        if (this.getWeight() > 0) {
            this.setWeight(this.getWeight() + foodWeight);
            System.out.println(getName() + " is feeded. New weight is: " + this.getWeight());
        } else {
            System.out.println(getName() + " is dead!");
        }
    }
}

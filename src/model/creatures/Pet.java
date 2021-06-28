package model.creatures;

public class Pet extends Animal {
    public Pet(String species) {
        super(species);
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

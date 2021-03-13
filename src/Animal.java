import java.io.File;

public class Animal {
    private String name;
    private Double weight;
    private final String species;
    private File pic;

    static final public Double DEFAULT_ANIMAL_WEIGHT = 1.0;

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


    public void feed() {
        if (this.weight > 0) {
            this.weight += 0.1;
            System.out.println("Animal is feeded. New weight is: " + this.weight);
        } else {
            System.out.println("Animal is dead! To much walk!");
        }
    }

    public void takeForAWalk() {
        if (this.weight > 0) {
            this.weight -= 0.1;
            System.out.println("Animal burned some calories. New weight is: " + this.weight);
        } else {
            System.out.println("Animal is dead! To much walk!");
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
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
}

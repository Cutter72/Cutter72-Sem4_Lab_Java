import model.Animal;
import model.Human;
import model.Phone;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal("canis");
        dog.setName("Szarik");
        dog.setWeight(15.0);
        System.out.println(dog);

        Animal cat = new Animal("feline");
        cat.setName("Puszek");
        System.out.println(cat);
        for (int i = 0; i < 7; i++) {
            cat.takeForAWalk();
            cat.takeForAWalk();
            cat.takeForAWalk();
            cat.takeForAWalk();
            cat.feed();
        }

        Phone s11 = new Phone();
        s11.setModel("S11");
        s11.setOperationSystem("Android");
        s11.setScreenSize("5\"");
        s11.setProducer("Samsung");
        System.out.println(s11);

        Human zygi = new Human();
        zygi.setName("Zygmunt");
        zygi.setLastName("Chajzer");
        zygi.setGender("Mężczyzna");
        zygi.setAge(50);
        zygi.setPhone(s11);
        System.out.println(zygi);
    }
}

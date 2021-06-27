import model.Animal;
import model.devices.Car;
import model.Human;
import model.devices.Phone;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal("canis");
        dog.setName("Szarik");
        dog.setWeight(15.0);
        System.out.println(dog);

        Animal cat = new Animal("feline");
        cat.setName("Puszek");
        System.out.println(cat);

        Phone s11 = new Phone();
        s11.setModel("S11");
        s11.setOperationSystem("Android");
        s11.setScreenSize("5\"");
        s11.setProducer("Samsung");
        System.out.println(s11);

        Car deLorean = new Car("DMC", "DeLorean DMC-12");
        deLorean.setHorsePower(130);
        deLorean.setValue(10000);
        System.out.println(deLorean);
        Car deLoreanForComparison = new Car("DMC", "DeLorean DMC-12");
        deLoreanForComparison.setHorsePower(130);
        deLoreanForComparison.setValue(10000);
        System.out.println(deLoreanForComparison);
        System.out.println("deLoreanForComparison == deLorean is " + (deLoreanForComparison == deLorean));
        System.out.println("deLoreanForComparison.equals(deLorean) is " + deLoreanForComparison.equals(deLorean));

        Human zygi = new Human();
        zygi.setName("Zygmunt");
        zygi.setLastName("Chajzer");
        zygi.setGender("Mężczyzna");
        zygi.setAge(67);
        zygi.setPhone(s11);
        zygi.setPet(dog);
        zygi.setSalary(1234.5678);
        zygi.setCar(deLorean);
        System.out.println(zygi);
    }
}

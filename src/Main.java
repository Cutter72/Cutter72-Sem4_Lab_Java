import model.creatures.Animal;
import model.creatures.Pet;
import model.devices.Car;
import model.Human;
import model.devices.Electric;
import model.devices.Phone;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Pet("canis");
        dog.setName("Szarik");
        dog.setWeight(15.0);
        dog.feed();
        System.out.println(dog);

        Animal cat = new Pet("feline");
        cat.setName("Puszek");
        cat.feed(2.21);
        System.out.println(cat);

        Phone s11 = new Phone();
        s11.setModel("S11");
        s11.setOperationSystem("Android");
        s11.setScreenSize("5\"");
        s11.setProducer("Samsung");
        s11.setYearOfProduction(2018);
        System.out.println(s11);

        Car deLorean = new Electric("DeLorean", "DMC-12");
        deLorean.setHorsePower(130);
        deLorean.setValue(10000.0);
        deLorean.setYearOfProduction(2024);
        System.out.println(deLorean);
        Car deLoreanForComparison = new Electric("DeLorean", "DMC-12");
        deLoreanForComparison.setHorsePower(130);
        deLoreanForComparison.setValue(10000.0);
        System.out.println(deLoreanForComparison);
        System.out.println("deLoreanForComparison == deLorean is " + (deLoreanForComparison == deLorean));
        System.out.println("deLoreanForComparison.equals(deLorean) is " + deLoreanForComparison.equals(deLorean));

        Human zygi = new Human();
        zygi.setName("Zygmunt");
        zygi.setLastName("Chajzer");
        zygi.setGender("Mężczyzna");
        zygi.setAge(67);
        zygi.setPet(dog);
        zygi.setSalary(1234.56);
        zygi.setCash(171.7);
        zygi.setCar(deLorean, 3);
        System.out.println(zygi);

        Human krzysiu = new Human();
        krzysiu.setName("Krzysztof");
        krzysiu.setLastName("Ibisz");
        krzysiu.setGender("Mężczyzna");
        krzysiu.setAge(56);
        krzysiu.setPhone(s11);
        krzysiu.setPet(cat);
        krzysiu.setSalary(4321.0);
        krzysiu.setCash(6543.0);
        krzysiu.setCar(deLoreanForComparison, 0);
        krzysiu.setCar(deLorean, 3);
        System.out.println(krzysiu);
        System.out.printf("%s posiada w garażu samochody o wartości %.2f zł.%n",
                krzysiu.getName(), krzysiu.getGargeValue());

        dog.sell(krzysiu, zygi, 1024.0);
        cat.sell(krzysiu, zygi, 1024.0);
        cat.sell(krzysiu, krzysiu, 1024.0);
        dog.sell(zygi, krzysiu, 1024.0);
        krzysiu.getPhone().sell(krzysiu, zygi, 170.0);
        try {
            deLorean.sell(zygi, krzysiu, 5000.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            deLoreanForComparison.sell(zygi, krzysiu, 5000.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            deLoreanForComparison.sell(zygi, krzysiu, 50.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("%s posiada w garażu samochody o wartości %.2f zł.%n",
                krzysiu.getName(), krzysiu.getGargeValue());

        deLorean.refuel();
        s11.installApp("Sudoku");
        s11.installApp("2048", "1.2");
        s11.installApp("Szachy", "1.1", "chess.com");
        s11.installApp(new ArrayList<>(Arrays.asList("Youtube", "Facebook", "Signal")));

        try {
            deLorean.sell(zygi, krzysiu, 1.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("deLorean.didHumanASellThisCarToHumanB(zygi, krzysiu): " +
                deLorean.didHumanASellThisCarToHumanB(zygi, krzysiu));
        System.out.println("deLorean.didHumanASellThisCarToHumanB(krzysiu, zygi): " +
                deLorean.didHumanASellThisCarToHumanB(krzysiu, zygi));
        System.out.println("deLorean.wasAnOwner(zygi): " + deLorean.wasAnOwner(zygi));
        System.out.println("deLorean.wasAnOwner(krzysiu): " + deLorean.wasAnOwner(krzysiu));
        System.out.println("deLorean.transactionsQuantity(): " + deLorean.transactionsQuantity());
    }
}

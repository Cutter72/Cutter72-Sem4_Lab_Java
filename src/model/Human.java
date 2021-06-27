package model;

import model.devices.Car;
import model.devices.Phone;

import java.util.Date;

public class Human {
    private String name;
    private String lastName;
    private int age;
    private String gender;
    private Phone phone;
    private Animal pet;
    private Car car;
    private Double salary;

    public Human() {
        this.salary = 0.0;
    }

    public Double getSalary() {
        System.out.printf("Salary at: %tT - %.2f%n", new Date(), this.salary);
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary >= 0) {
            System.out.println("New salary sent to database");
            System.out.println("Need new annex to the contract for Ms Hania from HR");
            System.out.println("No need to hide your income. ZUS and US already know your new salary.");
            this.salary = salary;
        } else {
            System.out.println("Error. Salary < 0");
        }
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if (this.salary > car.getValue()) {
            System.out.println("Car bought with cash!");
            this.car = car;
        } else if (this.salary > car.getValue() / 12) {
            System.out.println("Car bought with loan!");
            this.car = car;
        } else {
            System.out.println("Get a promotion or change a job!");
        }
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ",\n    age=" + age +
                ",\n    gender='" + gender + '\'' +
                ",\n    phone=" + phone +
                ",\n    pet=" + pet +
                ",\n    car=" + car +
                ",\n    salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

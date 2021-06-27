package model.devices;

public class Phone extends Device {
    private String operationSystem;
    private String screenSize;

    @Override
    public void turnOn() {
        System.out.println("Telefon włączony!");
    }

    @Override
    public String toString() {
        return "model.devices.Phone{" +
                "producer='" + getProducer() + '\'' +
                ", model='" + getModel() + '\'' +
                ", operationSystem='" + operationSystem + '\'' +
                ", screenSize='" + screenSize + '\'' +
                '}';
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
}

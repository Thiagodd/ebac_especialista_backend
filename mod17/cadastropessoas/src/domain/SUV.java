package domain;

public class SUV extends Car {

    private boolean AllWheelDrive;
    private int capacityLoad;

    public SUV(Long id, String model, String color, int ano, double price, boolean allWheelDrive, int capacityLoad) {
        super(id, model, color, ano, price);
        AllWheelDrive = allWheelDrive;
        this.capacityLoad = capacityLoad;
    }

    public boolean isAllWheelDrive() {
        return AllWheelDrive;
    }

    public void setAllWheelDrive(boolean allWheelDrive) {
        AllWheelDrive = allWheelDrive;
    }

    public int getCapacityLoad() {
        return capacityLoad;
    }

    public void setCapacityLoad(int capacityLoad) {
        this.capacityLoad = capacityLoad;
    }

    @Override
    public String toString() {
        return "SUV{" +
                "AllWheelDrive=" + AllWheelDrive +
                ", capacityLoad=" + capacityLoad +
                super.toString();
    }

    @Override
    public void upgradeEntity(Car entity) {
        if (entity instanceof SUV suvEntity) {
            this.setId(suvEntity.getId());
            this.setModel(suvEntity.getModel());
            this.setAno(suvEntity.getAno());
            this.setPrice(suvEntity.getPrice());
            this.setAllWheelDrive(suvEntity.isAllWheelDrive());
            this.setCapacityLoad(suvEntity.getCapacityLoad());
        }
    }
}

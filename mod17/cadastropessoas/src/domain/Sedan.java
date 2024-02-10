package domain;

public class Sedan extends Car {

    private int doorNumbers;
    private boolean airConditioning;

    public Sedan(Long id, String model, String color, int ano, double price, int doorNumbers, boolean airConditioning) {
        super(id, model, color, ano, price);
        this.doorNumbers = doorNumbers;
        this.airConditioning = airConditioning;
    }

    public int getDoorNumbers() {
        return doorNumbers;
    }

    public void setDoorNumbers(int doorNumbers) {
        this.doorNumbers = doorNumbers;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    @Override
    public String toString() {
        return "Sedan{" +
                super.toString() +
                "doorNumbers=" + doorNumbers +
                ", airConditioning=" + airConditioning +
                "}";
    }

    @Override
    public void upgradeEntity(Car entity) {
        if (entity instanceof Sedan sedanEntity){
            this.setId(sedanEntity.getId());
            this.setModel(sedanEntity.getModel());
            this.setAno(sedanEntity.getAno());
            this.setPrice(sedanEntity.getPrice());
            this.setDoorNumbers(sedanEntity.getDoorNumbers());
            this.setAirConditioning(sedanEntity.isAirConditioning());
        }
    }
}

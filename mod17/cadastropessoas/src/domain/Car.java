package domain;

import java.util.UUID;

public abstract class Car extends BaseEntity {

    private String model;
    private String color;
    private int ano;
    private double price;

    public Car(Long id, String model, String color, int ano, double price) {
        super(id);
        this.model = model;
        this.color = color;
        this.ano = ano;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                " model='" + model + '\'' +
                        ", color='" + color + '\'' +
                        ", ano=" + ano +
                        ", price=" + price
                ;
    }

    public abstract void upgradeEntity(Car entity);

    ;
}

package br.com.thiagodd.factorycar.cars;

import br.com.thiagodd.factorycar.SUVCar;

public class TCross extends SUVCar {

    @Override
    public void showSUVInformation() {
        System.out.println("Model: T-CROSS \nFactory: Volks \nCategory: SUV");
    }
}

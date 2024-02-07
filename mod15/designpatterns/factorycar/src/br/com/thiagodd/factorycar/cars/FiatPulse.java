package br.com.thiagodd.factorycar.cars;

import br.com.thiagodd.factorycar.SUVCar;

public class FiatPulse extends SUVCar {

    @Override
    public void showSUVInformation() {
        System.out.println("Model: FiatPulse \nFactory: Fiat \nCategory: SUV");
    }
}

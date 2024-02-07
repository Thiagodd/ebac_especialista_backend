package br.com.thiagodd.factorycar.cars;

import br.com.thiagodd.factorycar.SedanCar;

public class Siena extends SedanCar {

    @Override
    public void showSedanInformation() {
        System.out.println("Model: Siena \nFactory: Fiat \nCategory: Sedan");
    }
}

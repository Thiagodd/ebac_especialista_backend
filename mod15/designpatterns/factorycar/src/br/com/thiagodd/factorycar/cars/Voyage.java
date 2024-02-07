package br.com.thiagodd.factorycar.cars;

import br.com.thiagodd.factorycar.SedanCar;

public class Voyage extends SedanCar {
    @Override
    public void showSedanInformation() {
        System.out.println("Model: Voyage \nFactory: Volks \nCategory: Sedan");
    }
}

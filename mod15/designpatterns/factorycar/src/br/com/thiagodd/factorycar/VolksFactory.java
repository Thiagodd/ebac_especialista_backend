package br.com.thiagodd.factorycar;

import br.com.thiagodd.factorycar.cars.TCross;
import br.com.thiagodd.factorycar.cars.Voyage;

public class VolksFactory extends CarFactory{

    @Override
    public SedanCar buildSedanCar() {
        return new Voyage();
    }

    @Override
    public SUVCar buildSUVCar() {
        return new TCross();
    }
}

package br.com.thiagodd.factorycar;

import br.com.thiagodd.factorycar.cars.A3;
import br.com.thiagodd.factorycar.cars.Q7;

public class AudiFactory extends CarFactory{

    @Override
    public SedanCar buildSedanCar() {
        return new A3();
    }

    @Override
    public SUVCar buildSUVCar() {
        return new Q7();
    }
}

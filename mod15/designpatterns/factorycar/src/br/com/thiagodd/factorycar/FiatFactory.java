package br.com.thiagodd.factorycar;

import br.com.thiagodd.factorycar.cars.FiatPulse;
import br.com.thiagodd.factorycar.cars.Siena;

public class FiatFactory extends CarFactory{

    @Override
    public SedanCar buildSedanCar() {
        return new Siena();
    }

    @Override
    public SUVCar buildSUVCar() {
        return new FiatPulse();
    }
}

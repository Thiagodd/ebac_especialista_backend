package br.com.thiagodd.factory;

public abstract class Factory {

    public Car create(String requestGrade){
        Car car =retriaveCar(requestGrade);
        car = prepareCar(car);
        return car;
    }

    public Car prepareCar(Car car){
        car.clean();
        car.mechanicCheck();
        car.fuelCar();
        return car;
    }

    abstract Car retriaveCar(String requestedGrade);
}

package br.com.thiagodd.factory;

public class NoContractFactory extends Factory{
    @Override
    Car retriaveCar(String requestedGrade) {
        return null;
    }
}

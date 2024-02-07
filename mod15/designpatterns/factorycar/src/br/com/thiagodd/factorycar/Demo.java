package br.com.thiagodd.factorycar;

public class Demo {
    public static void main(String[] args) {

        CarFactory factory = new FiatFactory();
        SedanCar sedan = factory.buildSedanCar();
        SUVCar hatch = factory.buildSUVCar();

        sedan.showSedanInformation();
        System.out.println();
        hatch.showSUVInformation();
        System.out.println();

        factory = new VolksFactory();
        sedan = factory.buildSedanCar();
        hatch = factory.buildSUVCar();

        sedan.showSedanInformation();
        System.out.println();
        hatch.showSUVInformation();


    }
}

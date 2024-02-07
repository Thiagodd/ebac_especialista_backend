package br.com.thiagodd.factory;

public class Demo {

    public static void main(String[] args) {
        Costumer client = new Costumer("A", false);

        Factory factory = getFactory(client);
        factory.create(client.getGradeRequest());
    }

    private static Factory getFactory(Costumer client) {
        if(client.hasCompanyContract()){
            return new ContractFactory();
        } else {
            return new NoContractFactory();
        }
    }
}

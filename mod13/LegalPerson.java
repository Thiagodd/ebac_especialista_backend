package mod13;

public class LegalPerson extends Person{

    private String cnpj;
    private Integer numberEmployees;

    public LegalPerson(String name, String email, String address, String cnpj, Integer numberEmployees) {
        super(name, email, address);
        this.cnpj = cnpj;
        this.numberEmployees = numberEmployees;
    }

    public void performActivity() {
        System.out.println("Realizando atividade como Pessoa Juridica.");
    }

    public void displayCNPJ() {
        System.out.println("CNPJ: " + cnpj);
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }
}

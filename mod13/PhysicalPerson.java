package mod13;

public class PhysicalPerson extends Person{

    private String cpf;
    private String motherName;

    public PhysicalPerson(String name, String email, String address, String cpf, String motherName) {
        super(name, email, address);
        this.cpf = cpf;
        this.motherName = motherName;
    }

    public void performActivity() {
        System.out.println("Realizando atividade como Pessoa Física.");
    }

    public void displayCPF() {
        System.out.println("CPF: " + cpf);
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
}

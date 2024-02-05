package mod13;

public class Main {
    public static void main(String[] args) {
        PhysicalPerson pessoaFisica = new PhysicalPerson("João", "joao@email.com.br", "Rua A, 123", "123.456.789-01", "Maria Da Silva");

        pessoaFisica.displayInformation();
        pessoaFisica.performActivity();
        pessoaFisica.displayCPF();
        System.out.println();

        LegalPerson pessoaJuridica = new LegalPerson("Empresa XYZ", "contato@xyz.com.br", "Avenida B, 456", "12.345.678/0001-99", 10);

        pessoaJuridica.displayInformation();
        pessoaJuridica.performActivity();
        pessoaJuridica.displayCNPJ();
    }
}

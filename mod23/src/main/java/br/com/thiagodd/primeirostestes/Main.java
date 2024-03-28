package main.java.br.com.thiagodd.primeirostestes;


import main.java.br.com.thiagodd.primeirostestes.person.MockAllPersonsRepository;
import main.java.br.com.thiagodd.primeirostestes.person.MockWomanRepository;
import main.java.br.com.thiagodd.primeirostestes.person.Person;

import java.util.Scanner;

import static main.java.br.com.thiagodd.primeirostestes.person.MockAllPersonsRepository.getAllPersons;
import static main.java.br.com.thiagodd.primeirostestes.person.MockWomanRepository.findAll;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
//    private static final List<Person> allPersons = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("Bem-vindo ao programa de cadastro de pessoas!");
        displayNumberOfRegisteredPeople();

        while (addMorePeople()) {
            Person person = readPersonDetails();
            MockAllPersonsRepository.add(person);
            System.out.println("\n\n\u001B[32m" + person.getName() + " foi inserido(a) com sucesso." + "\u001B[0m");
        }


        getAllPersons()
                .stream()
                .filter(Person::isWoman)
                .forEach(MockWomanRepository::add);

        final var AllWoman = findAll();
        AllWoman.forEach(Person::printPerson);

        scanner.close();
    }

    private static void displayNumberOfRegisteredPeople() {
        System.out.printf("\nAtualmente existem %s pessoas cadastradas.\n", getAllPersons().size());
    }


    private static boolean addMorePeople() {
        System.out.print("Deseja adicionar mais uma pessoa? (sim/nao): ");
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("sim");
    }

    private static Person readPersonDetails() {
        if (getAllPersons().isEmpty()) {
            instructDataInsertion();
        }

        System.out.print("Digite os dados da pessoa: ");
        String userInput = scanner.nextLine();
        String[] personDetails = userInput.split(" ");

        if (personDetails.length != 2) {
            System.out.println("Formato inválido");
            instructDataInsertion();
        }

        String name = personDetails[0];
        String gender = personDetails[1];
        return instantiatePersonByGender(name, gender);
    }

    private static Person instantiatePersonByGender(String name, String gender) {
        return Person.newPessoa(name, gender);
    }

    private static void instructDataInsertion() {
        System.out.println("Por favor, informe o nome seguido do sexo ('masculino' ou 'feminino').");
        System.out.print("Exemplo: 'João masculino'\n");
    }
}
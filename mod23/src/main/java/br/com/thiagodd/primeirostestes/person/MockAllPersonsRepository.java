package main.java.br.com.thiagodd.primeirostestes.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockAllPersonsRepository {

    private static final List<Person> persons = new ArrayList<>();

    public static Person add(Person person) {

        persons.add(person);

        return person;
    }

    public static Optional<Person> find(String id) {
        return persons.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    public static Person remove(Person person) {
        persons.remove(person);

        return person;
    }

    public static void remove(String id) {
        final var personOptional = MockAllPersonsRepository.find(id);

        personOptional.ifPresent(persons::remove);
    }

    public static List<Person> getAllPersons(){
        return persons;
    }


}

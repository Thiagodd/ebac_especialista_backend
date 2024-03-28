package main.java.br.com.thiagodd.primeirostestes.person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MockWomanRepository extends MockAllPersonsRepository{

    private static final List<Person> allWoman = new ArrayList<>();

    public static Person add(Person person) {
        if (person.isWoman()){
            allWoman.add(person);
            return person;
        } else{
            throw new IllegalArgumentException("Não é permitido adicionar homens nesse repositorio.");
        }
    }

    public static Optional<Person> find(String id) {
        return allWoman.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    public static List<Person> findAll(){
        return Collections.unmodifiableList(allWoman);
    }

    public static Person remove(Person person) {
        allWoman.remove(person);

        return person;
    }

    public static void remove(String id) {
        final var personOptional = MockAllPersonsRepository.find(id);

        personOptional.ifPresent(allWoman::remove);
    }


}

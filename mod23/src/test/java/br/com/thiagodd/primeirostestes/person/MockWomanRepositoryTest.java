package test.java.br.com.thiagodd.primeirostestes.person;

import main.java.br.com.thiagodd.primeirostestes.person.Gender;
import main.java.br.com.thiagodd.primeirostestes.person.MockWomanRepository;
import main.java.br.com.thiagodd.primeirostestes.person.Person;
import org.junit.Assert;
import org.junit.Test;

public class MockWomanRepositoryTest {

    @Test
    public void givenValidFemalePerson_whenAddIsCalled_thenAddPersonToMockWomanRepository() {

        final var expectedName = "NomeFeminino";
        final var expectedGender = Gender.FEMALE;

        final var aPerson = Person.newPessoa(expectedName, expectedGender);
        final var persistedPerson = MockWomanRepository.add(aPerson);

        Assert.assertNotNull(persistedPerson);
        Assert.assertNotNull(persistedPerson.getId());
        Assert.assertEquals(expectedName, persistedPerson.getName());
        Assert.assertEquals(expectedGender, persistedPerson.getGender());

    }

    @Test
    public void givenValidMalePerson_whenAddIsCalled_thenThrowIllegalArgumentException() {

        final var expectedName = "NomeMasculino";
        final var expectedGender = Gender.MALE;

        final var aPerson = Person.newPessoa(expectedName, expectedGender);

        Assert.assertThrows( IllegalArgumentException.class, () -> MockWomanRepository.add(aPerson));
    }
}
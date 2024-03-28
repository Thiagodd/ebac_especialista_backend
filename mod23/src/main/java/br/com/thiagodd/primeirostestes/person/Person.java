package main.java.br.com.thiagodd.primeirostestes.person;

import java.util.Objects;
import java.util.UUID;

public class Person {

    private String id;
    private String name;
    private Gender gender;

    private Person(String id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public static Person newPessoa(String name, String gender){
        return newPessoa(name, Gender.getGenderByString(gender));
    }

    public static Person newPessoa(String name, Gender gender){
        final var id = UUID.randomUUID().toString().replace("-", "");

        return new Person(id, name, gender);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isWoman(){
        return getGender().equals(Gender.FEMALE);
    }

    public boolean isMan(){
        return getGender().equals(Gender.MALE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void printPerson(){
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender.getValue();
    }
}

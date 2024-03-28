package main.java.br.com.thiagodd.primeirostestes.person;

import java.util.Objects;

public enum Gender {
    MALE("masculino"),
    FEMALE("feminino");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Gender getGenderByString(String gender){
        final var genderLowCase = gender.toLowerCase();

        if (Objects.equals(genderLowCase, "f") || Objects.equals(genderLowCase, "famale") || Objects.equals(genderLowCase, "feminino")){
            return Gender.FEMALE;
        } else if(Objects.equals(genderLowCase, "m") || Objects.equals(genderLowCase, "male") || Objects.equals(genderLowCase, "masculino")){
            return Gender.MALE;
        }

        return null;
    }
}

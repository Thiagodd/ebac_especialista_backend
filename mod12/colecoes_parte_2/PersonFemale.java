package colecoes_parte_2;

public class PersonFemale implements Person {

    private String name;

    public PersonFemale(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getGender() {
        return "Feminino";
    }

    public static boolean isFemale(String gender) {
        return gender.equalsIgnoreCase("Feminino");
    }
}

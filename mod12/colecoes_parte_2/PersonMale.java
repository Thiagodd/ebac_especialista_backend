package colecoes_parte_2;

public class PersonMale implements Person {

    private String name;

    public PersonMale(String name) {
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
        return "Masculino";
    }

    public static boolean isMale(String gender) {
        return gender.equalsIgnoreCase("Masculino");
    }
}

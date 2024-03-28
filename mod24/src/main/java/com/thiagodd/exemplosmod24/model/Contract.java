package main.java.com.thiagodd.exemplosmod24.model;

import java.util.Objects;
import java.util.UUID;

public class Contract {
    private final String id;
    private String name;
    private String description;

    private Contract(String name, String description) {
        this.id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        this.name = name;
        this.description = description;
    }

    public static Contract newContract(String name){
        return newContract(name, "Description it is pending");
    }

    public static Contract newContract(String name, String description){
        return new Contract(name, description);
    }

    public Contract update(String name, String description){
        this.name = name;
        this.description = description;

        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(id, contract.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

package main.java.com.thiagodd.exemplosmod24.model;

import java.util.Objects;
import java.util.UUID;

public class Client {

    private final String id;
    private String name;

    private Client( String name) {
        this.id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        this.name = name;
    }

    public static Client newClient(String name){
        return new Client(name);
    }

    public Client update(String name){
        this.name = name;

        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

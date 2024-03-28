package main.java.br.com.thiagodd.model;

import main.java.br.com.thiagodd.annotations.TypePrimaryKey;

import java.util.Objects;
import java.util.UUID;

public class Client implements Persistence{

    private String id;
    private String name;

    @TypePrimaryKey("getCpf")
    private String cpf;
    private String phoneNumber;
    private String address;
    private int addressNumber;
    private String addressCity;
    private String addressState;

    private Client(String name, String cpf, String phoneNumber, String address, int addressNumber, String addressCity, String addressState) {
        this.id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.addressNumber = addressNumber;
        this.addressCity = addressCity;
        this.addressState = addressState;
    }

    public static Client newClient(String name, String cpf, String phoneNumber, String address, String addressNumber, String addressCity, String addressState) {
        return newClient(
                name,
                cpf,
                phoneNumber,
                address,
                Integer.parseInt(addressNumber.trim()),
                addressCity,
                addressState
        );
    }

    public static Client newClient(String name, String cpf, String phoneNumber, String address, int addressNumber, String addressCity, String addressState) {
        return new Client(
                name,
                cpf,
                phoneNumber,
                address,
                addressNumber,
                addressCity,
                addressState
        );
    }

    public Client update(Client client) {
        return update(
                this.name = client.getName(),
                this.cpf = client.getCpf(),
                this.phoneNumber = client.getPhoneNumber(),
                this.address = client.getAddress(),
                this.addressNumber = client.getAddressNumber(),
                this.addressCity = client.getAddressCity(),
                this.addressState = client.getAddressState()
        );
    }

    public Client update(String name, String cpf, String phoneNumber, String address, int addressNumber, String addressCity, String addressState) {
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.addressNumber = addressNumber;
        this.addressCity = addressCity;
        this.addressState = addressState;

        return this;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(cpf, client.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}

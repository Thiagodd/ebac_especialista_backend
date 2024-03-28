package main.java.br.com.thiagodd.dao;

import main.java.br.com.thiagodd.model.Client;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MockClientDAO implements IClientDAO {

    private static final Set<Client> clients = new HashSet<>();

    @Override
    public Client create(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public Optional<Client> findByIdentifier(String value) {

        return clients.stream()
                .filter(client -> client.getCpf().equals(value))
                .findFirst();
    }

    @Override
    public void deleteByIdentifier(String cpf) {
        final var client = findByIdentifier(cpf);
        client.ifPresent(clients::remove);
    }

    @Override
    public Client update(String id, Client client) {
        final var actualClient = findById(id);
        return actualClient
                .map(value -> value.update(client))
                .orElse(null);

    }

    @Override
    public Collection<Client> findAll() {
        return null;
    }

    private Optional<Client> findById(String id) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

}

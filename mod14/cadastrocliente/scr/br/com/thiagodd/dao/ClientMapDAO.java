package mod14.cadastrocliente.scr.br.com.thiagodd.dao;

import mod14.cadastrocliente.scr.br.com.thiagodd.domain.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientMapDAO implements IClientDAO {

    private final Map<Long, Client> clients;

    public ClientMapDAO() {
        clients = new HashMap<>();
    }

    @Override
    public boolean registerClient(Client client) {
        if (this.clients.containsKey(client.getCpf())) {
            return false;
        }
        clients.put(client.getCpf(), client);
        return true;
    }

    @Override
    public void delete(Long cpf) {
        Client savedClient = this.clients.get(cpf);

        if (savedClient != null) {
            clients.remove(savedClient.getCpf(), savedClient);
        }
    }

    @Override
    public void update(Client client) {
        Client savedClient = this.clients.get(client.getCpf());
        if (savedClient != null) {
            savedClient.setName(client.getName());
            savedClient.setCpf(client.getCpf());
            savedClient.setTelephone(client.getTelephone());
            savedClient.setAddress(client.getAddress());
            savedClient.setNumber(client.getNumber());
            savedClient.setCity(client.getCity());
            savedClient.setNumber(client.getNumber());
            savedClient.setState(client.getState());
        }
    }

    @Override
    public Client findByCpf(Long cpf) {
        return this.clients.get(cpf);
    }

    @Override
    public Collection<Client> findAll() {
        return this.clients.values();
    }
}

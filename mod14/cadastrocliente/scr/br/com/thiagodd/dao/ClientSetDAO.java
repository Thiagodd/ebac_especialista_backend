package mod14.cadastrocliente.scr.br.com.thiagodd.dao;

import mod14.cadastrocliente.scr.br.com.thiagodd.domain.Client;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClientSetDAO implements IClientDAO {

    private final Set<Client> clients;

    public ClientSetDAO() {
        clients = new HashSet<>();
    }

    @Override
    public boolean registerClient(Client client) {
        if (clients.contains(client)) {
            return false;
        }
        clients.add(client);
        return true;
    }

    @Override
    public void delete(Long cpf) {
        Client savedClient = null;

        for (Client client : this.clients){
            if (client.getCpf().equals(cpf)){
                savedClient = client;
                break;
            }
        }

        if (savedClient != null) {
            clients.remove(savedClient);
        }
    }

    @Override
    public void update(Client client) {

        if (this.clients.contains(client)) {
            for (Client clientCadastrado : this.clients){
                if (clientCadastrado.equals(client)){
                    clientCadastrado.setName(client.getName());
                    clientCadastrado.setCpf(client.getCpf());
                    clientCadastrado.setTelephone(client.getTelephone());
                    clientCadastrado.setAddress(client.getAddress());
                    clientCadastrado.setNumber(client.getNumber());
                    clientCadastrado.setCity(client.getCity());
                    clientCadastrado.setNumber(client.getNumber());
                    clientCadastrado.setState(client.getState());
                    break;
                }
            }
        }
    }

    @Override
    public Client findByCpf(Long cpf) {
        Client savedClient = null;

        for (Client client : this.clients){
            if (client.getCpf().equals(cpf)){
                savedClient = client;
                break;
            }
        }

        return savedClient;
    }

    @Override
    public Collection<Client> findAll() {
        return this.clients.stream().toList();
    }
}

package main.java.com.thiagodd.exemplosmod24.service;

import main.java.com.thiagodd.exemplosmod24.dao.client.IClientDAO;
import main.java.com.thiagodd.exemplosmod24.model.Client;

import java.util.Objects;

public class ClientService implements IClientService {

    private final IClientDAO clientDAO;

    public ClientService(IClientDAO iClientDAO) {
        this.clientDAO = Objects.requireNonNull(iClientDAO);
    }

    public String save(Client client){
        clientDAO.save(client);
        return "successfully";
    }

    @Override
    public String find(String id) {
        clientDAO.find(id);
        return "successfully";
    }

    @Override
    public String update(String id, Client client) {
        clientDAO.update(id, client);
        return "successfully";
    }

    @Override
    public String delete(String id) {
        clientDAO.delete(id);
        return "successfully";
    }
}

package main.java.com.thiagodd.exemplosmod24.dao.client;

import main.java.com.thiagodd.exemplosmod24.model.Client;

public interface IClientDAO {

    void save(Client client);
    void find(String id);
    void update(String id, Client client);
    void delete(String name);
}

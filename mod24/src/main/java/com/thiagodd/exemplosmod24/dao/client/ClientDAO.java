package main.java.com.thiagodd.exemplosmod24.dao.client;

import main.java.com.thiagodd.exemplosmod24.model.Client;

public class ClientDAO implements IClientDAO {

    @Override
    public void save(Client client) {
        throw new UnsupportedOperationException("Does not work without database config");
    }

    @Override
    public void find(String id) {
        throw new UnsupportedOperationException("Does not work without database config");
    }

    @Override
    public void update(String id, Client client) {
        throw new UnsupportedOperationException("Does not work without database config");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Does not work without database config");
    }
}

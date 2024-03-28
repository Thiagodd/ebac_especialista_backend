package main.java.br.com.thiagodd.dao;

import main.java.br.com.thiagodd.dao.generic.GenericDAO;
import main.java.br.com.thiagodd.model.Client;

import java.util.List;
import java.util.Optional;

public class ClientDAO extends GenericDAO<Client, String> implements IClientDAO {


    public ClientDAO() {
        super();
    }

    @Override
    public Class<Client> getClassType() {
        return Client.class;
    }

    @Override
    public void updateData(Client entity, Client persistedEntity) {

    }

}

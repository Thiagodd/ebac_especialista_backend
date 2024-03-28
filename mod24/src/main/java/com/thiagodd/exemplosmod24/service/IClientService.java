package main.java.com.thiagodd.exemplosmod24.service;

import main.java.com.thiagodd.exemplosmod24.model.Client;

public interface IClientService {

    String save(Client client);
    String find(String id);
    String update(String id, Client client);
    String delete(String id);
}

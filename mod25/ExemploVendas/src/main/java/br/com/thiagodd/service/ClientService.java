package main.java.br.com.thiagodd.service;

import main.java.br.com.thiagodd.dao.IClientDAO;
import main.java.br.com.thiagodd.exceptions.PrimaryKeyTypeNotFoundException;
import main.java.br.com.thiagodd.model.Client;
import main.java.br.com.thiagodd.service.generic.GenericService;
import main.java.br.com.thiagodd.service.generic.IGenericService;

import java.util.Optional;

public class ClientService extends GenericService<Client, String> implements IClientService {

    public ClientService(IClientDAO clientDAO) {
        super(clientDAO);
    }

}

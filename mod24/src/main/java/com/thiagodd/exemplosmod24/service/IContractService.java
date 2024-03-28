package main.java.com.thiagodd.exemplosmod24.service;

import main.java.com.thiagodd.exemplosmod24.model.Contract;

public interface IContractService {

    String save(Contract contract);
    String find(String id);
    String update(String id, Contract contract);
    String delete(String id);
}

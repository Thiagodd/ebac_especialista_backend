package main.java.com.thiagodd.exemplosmod24.dao.contract;

import main.java.com.thiagodd.exemplosmod24.model.Contract;

public interface IContractDAO {

    void save(Contract contract);
    void find(String id);
    void update(String id, Contract contract);
    void delete(String name);

}

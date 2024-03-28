package main.java.com.thiagodd.exemplosmod24.dao.contract;

import main.java.com.thiagodd.exemplosmod24.model.Contract;

public class ContractDAO implements IContractDAO {

    @Override
    public void save(Contract contract) {
        throw new UnsupportedOperationException("Does not work without database config");
    }

    @Override
    public void find(String id) {
        throw new UnsupportedOperationException("Does not work without database config");
    }

    @Override
    public void update(String id, Contract contract) {
        throw new UnsupportedOperationException("Does not work without database config");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Does not work without database config");
    }
}

package main.java.com.thiagodd.exemplosmod24.service;

import main.java.com.thiagodd.exemplosmod24.dao.contract.IContractDAO;
import main.java.com.thiagodd.exemplosmod24.model.Contract;

import java.util.Objects;

public class ContractService implements IContractService{

    private final IContractDAO contractDAO;

    public ContractService(final IContractDAO contractDAO) {
        this.contractDAO = Objects.requireNonNull(contractDAO);
    }

    @Override
    public String save(Contract contract){
        contractDAO.save(contract);
        return "successfully";
    }

    @Override
    public String find(String id) {
        contractDAO.find(id);
        return "successfully";
    }

    @Override
    public String update(String name, Contract contract) {
        contractDAO.update(name, contract);
        return "successfully";
    }

    @Override
    public String delete(String id) {
        contractDAO.delete(id);
        return "successfully";
    }
}

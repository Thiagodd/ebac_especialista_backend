package test.java.com.thiagodd.exemplosmod24.service;

import main.java.com.thiagodd.exemplosmod24.dao.contract.ContractDAO;
import main.java.com.thiagodd.exemplosmod24.dao.contract.MockContractDAO;
import main.java.com.thiagodd.exemplosmod24.model.Contract;
import main.java.com.thiagodd.exemplosmod24.service.ContractService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class ContractServiceTest {

    @Test
    public void givenAValidContract_whenCalledSave_whenReturnSuccessfully(){
        final var service = new ContractService(new MockContractDAO());
        final var validContract = Contract.newContract("EmpresaX", "Contrato de locação");

        final var response = service.save(validContract);

        Assertions.assertEquals("successfully", response);
    }

    @Test
    public void givenAInvalidMock_whenCalledSave_whenThrowUnsupportedOperationException() {
        final var service = new ContractService(new ContractDAO());
        final var validContract = Contract.newContract("EmpresaX", "Contrato de locação");

        Assertions.assertThrows(UnsupportedOperationException.class, () -> service.save(validContract));
    }

    @Test
    public void givenAValidContract_whenCalledUpdate_whenReturnSuccessfully(){
        final var service = new ContractService(new MockContractDAO());
        final var validContract = Contract.newContract("EmpresaX", "Contrato de locação");
        final var validId = "1234";

        final var response = service.update(validId, validContract);

        Assertions.assertEquals("successfully", response);
    }

    @Test
    public void givenAValidId_whenCalledFind_whenReturnSuccessfully(){
        final var service = new ContractService(new MockContractDAO());
        final var validId = "1234";

        final var response = service.find(validId);

        Assertions.assertEquals("successfully", response);
    }

    @Test
    public void givenAValidId_whenCalledDelete_whenReturnSuccessfully(){
        final var service = new ContractService(new MockContractDAO());
        final var validId = "1234";

        final var response = service.delete(validId);

        Assertions.assertEquals("successfully", response);
    }
}

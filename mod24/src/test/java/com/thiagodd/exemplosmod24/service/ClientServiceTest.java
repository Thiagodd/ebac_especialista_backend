package test.java.com.thiagodd.exemplosmod24.service;

import main.java.com.thiagodd.exemplosmod24.dao.client.ClientDAO;
import main.java.com.thiagodd.exemplosmod24.dao.client.MockClientDAO;
import main.java.com.thiagodd.exemplosmod24.model.Client;
import main.java.com.thiagodd.exemplosmod24.service.ClientService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class ClientServiceTest {


    @Test
    public void givenAValidClient_whenCalledSave_whenReturnSuccessfully(){
        final var service = new ClientService(new MockClientDAO());
        final var validClient = Client.newClient("ClientX");

        final var response = service.save(validClient);

        Assertions.assertEquals("successfully", response);
    }

    @Test
    public void givenAInvalidMock_whenCalledSave_whenThrowUnsupportedOperationException() {
        final var service = new ClientService(new ClientDAO());
        final var validClient = Client.newClient("ClientX");

        Assertions.assertThrows(UnsupportedOperationException.class, () -> service.save(validClient));
    }

    @Test
    public void givenAValidContract_whenCalledUpdate_whenReturnSuccessfully(){
        final var service = new ClientService(new MockClientDAO());
        final var validClient = Client.newClient("ClientX");
        final var validId = "1234";

        final var response = service.update(validId, validClient);

        Assertions.assertEquals("successfully", response);
    }

    @Test
    public void givenAValidId_whenCalledFind_whenReturnSuccessfully(){
        final var service = new ClientService(new MockClientDAO());
        final var validId = "1234";

        final var response = service.find(validId);

        Assertions.assertEquals("successfully", response);
    }

    @Test
    public void givenAValidId_whenCalledDelete_whenReturnSuccessfully(){
        final var service = new ClientService(new MockClientDAO());
        final var validId = "1234";

        final var response = service.delete(validId);

        Assertions.assertEquals("successfully", response);
    }
}
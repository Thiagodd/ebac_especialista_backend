package test.java.br.com.thiagodd;

import main.java.br.com.thiagodd.dao.MockClientDAO;
import main.java.br.com.thiagodd.exceptions.PrimaryKeyTypeNotFoundException;
import main.java.br.com.thiagodd.model.Client;
import main.java.br.com.thiagodd.service.ClientService;
import main.java.br.com.thiagodd.service.IClientService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class ClientServiceTest {

    private IClientService clientService;

    @Before
    public void setUp() {
        this.clientService = new ClientService(new MockClientDAO());
    }


    @Test
    public void givenAValidClient_whenCallsCreate_shouldReturnClient() throws PrimaryKeyTypeNotFoundException {
        final var expectedName = "Thiago";
        final var expectedCPF = "12345678912";
        final var expectedPhoneNumber = "11912344321";
        final var expectedAddress = "Rua do Limoeiro";
        final var expectedAddressNumber = 19;
        final var expectedAddressCity = "Campinas";
        final var expectedAddressState = "Sao Paulo";

        final var aClient = Client.newClient(expectedName, expectedCPF, expectedPhoneNumber, expectedAddress, expectedAddressNumber, expectedAddressCity, expectedAddressState);

        final var actualOutput = clientService.create(aClient);

        Assert.assertNotNull(actualOutput);
    }

    @Test
    public void givenAValidCPF_whenCallsFindByIdentifier_shouldReturnClientFound() throws PrimaryKeyTypeNotFoundException {
        final var expectedName = "Thiago";
        final var expectedCPF = "12345678912";
        final var expectedPhoneNumber = "11912344321";
        final var expectedAddress = "Rua do Limoeiro";
        final var expectedAddressNumber = 19;
        final var expectedAddressCity = "Campinas";
        final var expectedAddressState = "Sao Paulo";

        final var aClient = Client.newClient(expectedName, expectedCPF, expectedPhoneNumber, expectedAddress, expectedAddressNumber, expectedAddressCity, expectedAddressState);

        clientService.create(aClient);

        final var actualClientOptional = clientService.findByIdentifier(expectedCPF);
        Assert.assertTrue(actualClientOptional.isPresent());

        final var actualClient = actualClientOptional.get();

        Assert.assertNotNull(actualClient);
        Assert.assertNotNull(actualClient.getId());
        Assert.assertEquals(expectedName, actualClient.getName());
        Assert.assertEquals(expectedCPF, actualClient.getCpf());
        Assert.assertEquals(expectedPhoneNumber, actualClient.getPhoneNumber());
        Assert.assertEquals(expectedAddress, actualClient.getAddress());
        Assert.assertEquals(expectedAddressNumber, actualClient.getAddressNumber());
        Assert.assertEquals(expectedAddressCity, actualClient.getAddressCity());
        Assert.assertEquals(expectedAddressState, actualClient.getAddressState());
    }

    @Test
    public void givenAValidCPF_whenCallsDeleteByCPF_shouldBeOk() throws PrimaryKeyTypeNotFoundException {
        final var expectedName = "Thiago";
        final var expectedCPF = "12345678912";
        final var expectedPhoneNumber = "11912344321";
        final var expectedAddress = "Rua do Limoeiro";
        final var expectedAddressNumber = 19;
        final var expectedAddressCity = "Campinas";
        final var expectedAddressState = "Sao Paulo";

        final var aClient = Client.newClient(expectedName, expectedCPF, expectedPhoneNumber, expectedAddress, expectedAddressNumber, expectedAddressCity, expectedAddressState);
        clientService.create(aClient);
        var actualClient = clientService.findByIdentifier(expectedCPF);
        Assert.assertTrue(actualClient.isPresent());

        clientService.deleteByIdentifier(expectedCPF);

        Optional<Client> actualClient2 = clientService.findByIdentifier(expectedCPF);
        Assert.assertFalse(actualClient2.isPresent());
    }

    @Test
    public void givenAValidIDAndClient_whenCallsUpdate_shouldReturnClientUpdated() throws PrimaryKeyTypeNotFoundException {
        final var expectedName = "Thiago";
        final var expectedCPF = "12345678912";
        final var expectedPhoneNumber = "11912344321";
        final var expectedAddress = "Rua do Limoeiro";
        final var expectedAddressNumber = 19;
        final var expectedAddressCity = "Campinas";
        final var expectedAddressState = "Sao Paulo";

        final var aClient = Client.newClient("Tiago", "12345678919", "119152521", "Rua do Abacateiro", 11, "Jardins", "Sao Paulo");
        clientService.create(aClient);
        final var actualClientOptional = clientService.findByIdentifier(aClient.getCpf());
        Assert.assertTrue(actualClientOptional.isPresent());

        final var updatedClient =
                actualClientOptional.get().update(expectedName, expectedCPF, expectedPhoneNumber, expectedAddress, expectedAddressNumber, expectedAddressCity, expectedAddressState);

        final var persistedUpdatedClient =
                clientService.update(actualClientOptional.get().getId(), updatedClient);

        Assert.assertNotNull(persistedUpdatedClient);
        Assert.assertNotNull(persistedUpdatedClient.getId());
        Assert.assertEquals(expectedName, persistedUpdatedClient.getName());
        Assert.assertEquals(expectedCPF, persistedUpdatedClient.getCpf());
        Assert.assertEquals(expectedPhoneNumber, persistedUpdatedClient.getPhoneNumber());
        Assert.assertEquals(expectedAddress, persistedUpdatedClient.getAddress());
        Assert.assertEquals(expectedAddressNumber, persistedUpdatedClient.getAddressNumber());
        Assert.assertEquals(expectedAddressCity, persistedUpdatedClient.getAddressCity());
        Assert.assertEquals(expectedAddressState, persistedUpdatedClient.getAddressState());
    }
}

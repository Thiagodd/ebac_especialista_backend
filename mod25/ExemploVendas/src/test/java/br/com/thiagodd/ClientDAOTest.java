package test.java.br.com.thiagodd;

import main.java.br.com.thiagodd.dao.ClientDAO;
import main.java.br.com.thiagodd.dao.IClientDAO;
import main.java.br.com.thiagodd.exceptions.PrimaryKeyTypeNotFoundException;
import main.java.br.com.thiagodd.model.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class ClientDAOTest {

    private IClientDAO mockClientDAO;

    @Before
    public void setUp(){
        this.mockClientDAO = new ClientDAO();
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

        final var actualOutput = mockClientDAO.create(aClient);

        Assert.assertNotNull(actualOutput);
    }

    @Test
    public void givenAValidCPF_whenCallsFindByCPF_shouldReturnClientFound() throws PrimaryKeyTypeNotFoundException {
        final var expectedName = "Thiago";
        final var expectedCPF = "12345678912";
        final var expectedPhoneNumber = "11912344321";
        final var expectedAddress = "Rua do Limoeiro";
        final var expectedAddressNumber = 19;
        final var expectedAddressCity = "Campinas";
        final var expectedAddressState = "Sao Paulo";

        final var aClient = Client.newClient(expectedName, expectedCPF, expectedPhoneNumber, expectedAddress, expectedAddressNumber, expectedAddressCity, expectedAddressState);

        mockClientDAO.create(aClient);

        final var actualClientOptional = mockClientDAO.findByIdentifier(expectedCPF);
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
        mockClientDAO.create(aClient);
        var actualClient = mockClientDAO.findByIdentifier(expectedCPF);
        Assert.assertTrue(actualClient.isPresent());

        mockClientDAO.deleteByIdentifier(expectedCPF);

        Optional<Client> actualClient2 = mockClientDAO.findByIdentifier(expectedCPF);
        Assert.assertFalse(actualClient2.isPresent());

    }
}

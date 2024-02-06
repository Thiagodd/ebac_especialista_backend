package mod14.cadastrocliente.scr.br.com.thiagodd.dao;

import mod14.cadastrocliente.scr.br.com.thiagodd.domain.Client;

import java.util.Collection;

public interface IClientDAO {

    boolean registerClient(Client client);
    void delete(Long cpf);
    void update(Client client);
    Client findByCpf(Long cpf);
    Collection<Client> findAll();



}

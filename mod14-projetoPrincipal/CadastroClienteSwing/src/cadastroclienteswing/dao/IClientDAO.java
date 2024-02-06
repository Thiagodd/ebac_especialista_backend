/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclienteswing.dao;

import cadastroclienteswing.domain.Client;
import java.util.Collection;


/**
 *
 * @author thiagodd
 */
public interface IClientDAO {
    boolean registerClient(Client client);
    void delete(Long cpf);
    void update(Client client);
    Client findByCpf(Long cpf);
    Collection<Client> findAll();
    
}

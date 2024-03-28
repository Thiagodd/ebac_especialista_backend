package main.java.br.com.thiagodd.service.generic;

import main.java.br.com.thiagodd.exceptions.PrimaryKeyTypeNotFoundException;
import main.java.br.com.thiagodd.model.Persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface IGenericService<T extends Persistence, E extends Serializable> {

    T create(T entity) throws PrimaryKeyTypeNotFoundException;
    Optional<T> findByIdentifier(E cpf);
    void deleteByIdentifier(E cpf);
    T update(E id, T entity) throws PrimaryKeyTypeNotFoundException;
    Collection<T> findAll();
}

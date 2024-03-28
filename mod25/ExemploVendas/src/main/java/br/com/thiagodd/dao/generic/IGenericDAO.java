package main.java.br.com.thiagodd.dao.generic;

import main.java.br.com.thiagodd.exceptions.PrimaryKeyTypeNotFoundException;
import main.java.br.com.thiagodd.model.Persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface IGenericDAO<T extends Persistence, E extends Serializable> {

    T create(T entity) throws PrimaryKeyTypeNotFoundException;

    Optional<T> findByIdentifier(E value);

    void deleteByIdentifier(E value);

    T update(E id, T entity) throws PrimaryKeyTypeNotFoundException;

    Collection<T> findAll();
}

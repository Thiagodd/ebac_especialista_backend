package main.java.br.com.thiagodd.service.generic;

import main.java.br.com.thiagodd.dao.generic.IGenericDAO;
import main.java.br.com.thiagodd.exceptions.PrimaryKeyTypeNotFoundException;
import main.java.br.com.thiagodd.model.Persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public class GenericService<T extends Persistence, E extends Serializable> implements IGenericService<T, E> {


    protected IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }

    @Override
    public T create(T entity) throws PrimaryKeyTypeNotFoundException {
        return this.dao.create(entity);
    }

    @Override
    public Optional<T> findByIdentifier(E cpf) {
        return dao.findByIdentifier(cpf);
    }

    @Override
    public void deleteByIdentifier(E cpf) {
        this.dao.deleteByIdentifier(cpf);
    }

    @Override
    public T update(E id, T entity) throws PrimaryKeyTypeNotFoundException {
        return this.dao.update(id, entity);
    }

    @Override
    public Collection<T> findAll() {
        return this.dao.findAll();
    }
}

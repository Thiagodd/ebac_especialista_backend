package repository;

import domain.BaseEntity;

import java.util.Collection;


public interface IGenericRepository<T extends BaseEntity> {

    Boolean save(T entity);

    void delete(Long id);

    void update(T entity);

    T find(Long id);

    Collection<T> findAll();

}

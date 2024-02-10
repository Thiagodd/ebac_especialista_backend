package repository;

import database.MockFakeDatabase;
import domain.Car;

import java.util.*;

public class GenericRepositoryImpl<T extends Car> implements IGenericRepository<T> {

    private final MockFakeDatabase mockFakeDatabase = MockFakeDatabase.getInstance();

    public GenericRepositoryImpl() {
    }

    @Override
    public Boolean save(T entity) {
        boolean isContainsEntityInMemory = getCarsList().contains(entity);

        if (isContainsEntityInMemory) {
            return false;
        }

        getCarsList().add(entity);

        return true;
    }

    private List<Car> getCarsList() {
        return mockFakeDatabase.getData();
    }

    @Override
    public void delete(Long id) {
        getCarsList().removeIf(entity -> Objects.equals(entity.getId(), id));
    }

    @Override
    public void update(T entity) {
        for (Car entityInMemory : getCarsList()) {
            if (Objects.equals(entityInMemory.getId(), entity.getId())) {
                entity.upgradeEntity(entity);
            }
        }
    }

    @Override
    public T find(Long id) {

        for (Car entityInMemory : getCarsList()) {
            if (Objects.equals(entityInMemory.getId(), id)) {
                return (T) entityInMemory;
            }
        }

        return null;
    }

    @Override
    public Collection<T> findAll() {
        return (List<T>) getCarsList();
    }


}

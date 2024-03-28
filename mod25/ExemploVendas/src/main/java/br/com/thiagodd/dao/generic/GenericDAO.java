package main.java.br.com.thiagodd.dao.generic;

import main.java.br.com.thiagodd.annotations.TypePrimaryKey;
import main.java.br.com.thiagodd.exceptions.PrimaryKeyTypeNotFoundException;
import main.java.br.com.thiagodd.model.Persistence;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class GenericDAO<T extends Persistence, E extends Serializable> implements IGenericDAO<T, E> {

    private final SingletonMap singletonMap;

    public abstract Class<T> getClassType();

    public abstract void updateData(T entity, T persistedEntity);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    public E getPrimaryKey(T entity) throws PrimaryKeyTypeNotFoundException {
        Field[] fields = entity.getClass().getDeclaredFields();
        E returnValue = null;

        for (Field field : fields) {
            if (field.isAnnotationPresent(TypePrimaryKey.class)) {
                final var typePrimaryKey = field.getAnnotation(TypePrimaryKey.class);
                String methodName = typePrimaryKey.value();

                System.out.printf(methodName);

                try {
                    final var method = entity.getClass().getMethod(methodName);
                    returnValue = (E) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
                    exception.printStackTrace();
                    throw new PrimaryKeyTypeNotFoundException("Primary key of object " + entity.getClass() + "was not found.");
                }
            }
        }

        System.out.println("**** ERROR ****");
        throw new PrimaryKeyTypeNotFoundException("Primary key of object " + entity.getClass() + "was not found.");
    }

    @Override
    public T create(T entity) throws PrimaryKeyTypeNotFoundException {
        Map<E, T> internalMap =  this.getInternalMap();

        E primaryKey = getPrimaryKey(entity);
        if (internalMap.containsKey(primaryKey)) {
            return null;
        }

        internalMap.put(primaryKey, entity);

        return entity;
    }

    @Override
    public Optional<T> findByIdentifier(E value) {
        Map<E, T> internalMap = this.getInternalMap();
        T persistedEntity = internalMap.get(value);

        if (persistedEntity != null){
            return Optional.of(persistedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void deleteByIdentifier(E value) {
        Map<E, T> internalMap =  this.getInternalMap();
        T persistedEntity = internalMap.get(value);

        if (persistedEntity != null){
            internalMap.remove(value, persistedEntity);
        }
    }

    @Override
    public T update(E id, T entity) throws PrimaryKeyTypeNotFoundException {
        Map<E, T> internalMap = this.getInternalMap();
        E primaryKey = getPrimaryKey(entity);
        T persistedEntity = internalMap.get(primaryKey);

        if (persistedEntity != null){
            updateData(entity, persistedEntity);
            return persistedEntity;
        }
        return null;
    }

    public Collection<T> findAll(){
        Map<E, T> internalMap = this.getInternalMap();

        return internalMap.values();
    }

    private Map<E, T> getInternalMap(){
        Map<E, T> internalMap = (Map<E, T>) this.singletonMap.getMap().get(getClassType());
        if (internalMap == null){
            internalMap = new HashMap<>();
            this.singletonMap.getMap().put(getClassType(), internalMap);
        }

        return internalMap;
    }
}

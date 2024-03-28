package main.java.br.com.thiagodd.dao;

import main.java.br.com.thiagodd.model.Product;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MockProductDAO implements IProductDAO {

    private static final Set<Product> products = new HashSet<>();

    @Override
    public Product create(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findByIdentifier(String value) {

        return products.stream()
                .filter(product -> product.getId().equals(value))
                .findFirst();
    }

    @Override
    public void deleteByIdentifier(String cpf) {
        final var product = findByIdentifier(cpf);
        product.ifPresent(products::remove);
    }

    @Override
    public Product update(String id, Product client) {
        final var actualProduct = findById(id);
        return actualProduct
                .map(value -> value.update(client))
                .orElse(null);

    }

    @Override
    public Collection<Product> findAll() {
        return null;
    }

    private Optional<Product> findById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

}

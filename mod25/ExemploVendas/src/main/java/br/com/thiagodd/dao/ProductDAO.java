package main.java.br.com.thiagodd.dao;

import main.java.br.com.thiagodd.dao.generic.GenericDAO;
import main.java.br.com.thiagodd.model.Client;
import main.java.br.com.thiagodd.model.Product;

public class ProductDAO extends GenericDAO<Product, String> implements IProductDAO {


    public ProductDAO() {
        super();
    }

    @Override
    public Class<Product> getClassType() {
        return Product.class;
    }

    @Override
    public void updateData(Product entity, Product persistedEntity) {

    }

}

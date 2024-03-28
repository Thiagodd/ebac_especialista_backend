package main.java.br.com.thiagodd.service;

import main.java.br.com.thiagodd.dao.IProductDAO;
import main.java.br.com.thiagodd.model.Product;
import main.java.br.com.thiagodd.service.generic.GenericService;

public class ProductService extends GenericService<Product, String> implements IProductService {

    public ProductService(IProductDAO productDAO) {
        super(productDAO);
    }

}

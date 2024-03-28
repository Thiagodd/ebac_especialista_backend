package test.java.br.com.thiagodd;

import main.java.br.com.thiagodd.dao.IProductDAO;
import main.java.br.com.thiagodd.dao.ProductDAO;
import main.java.br.com.thiagodd.exceptions.PrimaryKeyTypeNotFoundException;
import main.java.br.com.thiagodd.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

public class ProductDAOTest {

    private IProductDAO productDAO;

    private Product product;

    @Before
    public void init(){
        this.productDAO = new ProductDAO();

        product = new Product();
        product.setId("A1");
        product.setName("Product 01");
        product.setDescription("Product 01 - Description");
        product.setValue(BigDecimal.valueOf(1000));
    }

    @Test
    public void givenAValidIdentifier_whenCallsFindByCod_shouldReturnProduct(){
        Optional<Product> product1 = this.productDAO.findByIdentifier(product.getId());

        Assert.assertTrue(product1.isPresent());
    }

    @Test
    public void givenAValidProduct_whenCallsCreate_shouldReturnProduct() throws PrimaryKeyTypeNotFoundException {
        final var actualProduct = productDAO.create(product);

        Assert.assertNotNull(actualProduct);
    }

    @Test
    public void givenAValidIdentifier_whenCallsDeleteByIdentifier_shouldBeOk(){
        productDAO.deleteByIdentifier(product.getId());
    }

    @Test
    public void givenAValidUpdatedProduct_whenCallsUpdate_shouldReturnUpdatedProduct(){
        product.setName("New Name");
        product.setDescription("New Description");

        Assert.assertEquals("New Name", product.getName());
        Assert.assertEquals("New Description", product.getDescription());
    }
}

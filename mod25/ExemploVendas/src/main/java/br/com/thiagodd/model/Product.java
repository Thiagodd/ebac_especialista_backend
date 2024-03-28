package main.java.br.com.thiagodd.model;

import main.java.br.com.thiagodd.annotations.TypePrimaryKey;

import java.math.BigDecimal;

public class Product implements Persistence{

    @TypePrimaryKey("getId")
    private String id;
    private String name;
    private String description;
    private BigDecimal value;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public Product update(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.value = product.getValue();

        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

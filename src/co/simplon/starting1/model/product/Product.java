package co.simplon.starting1.model.product;

import java.util.Objects;

import co.simplon.starting1.model.client.Client;
import co.simplon.starting1.model.common.Entity;

public abstract class Product extends Entity {

    private static final long serialVersionUID = 1L;

    private String name;

    private float sellingPrice; // le prix de vente

    private float buyingPrice; // le prix d'achat

    public Product(String name, float sellingPrice, float buyingPrice) {

	this.name = name;
	setSellingPrice(sellingPrice);
	setBuyingPrice(buyingPrice);
    }

    public String getName() {

	return name;
    }

    public void setName(String name) {

	if (name.isEmpty())
	    throw new IllegalArgumentException("Empty product name not allowed");

	this.name = name;
    }

    public float getSellingPrice() {

	return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {

	if (sellingPrice <= 0)
	    throw new IllegalArgumentException("Negative/zero number is not allowed !");

	this.sellingPrice = sellingPrice;
    }

    public float getBuyingPrice() {

	return buyingPrice;
    }

    public void setBuyingPrice(float buyingPrice) {

	if (buyingPrice <= 0)
	    throw new IllegalArgumentException("Negative number is not allowed !");

	this.buyingPrice = buyingPrice;
    }
    
    @Override
    public boolean equals(Object obj) {

	if (Objects.isNull(obj))
	    return false;
	Product ProductToCheck = (Product) obj;
	return ProductToCheck.getName().equals(this.name) 
		&& ProductToCheck.getBuyingPrice() == this.getBuyingPrice()
		&& ProductToCheck.getSellingPrice() == this.getSellingPrice()
		? true : false;
    }

}

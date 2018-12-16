package co.simplon.starting1.model.shop;

import co.simplon.starting1.model.product.Product;

public class Stock {
    
    private int quantity;
    private final Product product;

    public Stock(int quantity, Product product) {
	this.product = product;
	setQuantity(quantity);
    }

    public Product getProduct() {
	return product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
	return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {

	if (quantity < 0)
	    throw new IllegalArgumentException("Invalid quantity value.");

	this.quantity = quantity;
    }
    
    public boolean inStock() {
	return ( getQuantity() > 0 );
    }

    public boolean canIOrderQTY(int qty) {
	return ( getQuantity() >= qty );
    }
}

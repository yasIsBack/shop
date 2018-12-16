package co.simplon.starting1.model.order;

import co.simplon.starting1.model.client.Client;
import co.simplon.starting1.model.common.Entity;
import co.simplon.starting1.model.product.Product;
import co.simplon.starting1.model.shop.Shop;

public class Order extends Entity {

    private static final long serialVersionUID = 1L;

    private int quantity;
    private boolean delivered;
    private Client user;
    private Shop orderFrmShop;
    private Product productToOrder;

    public Order(int quantity, boolean delivered, Client user, Shop orderFrmShop, Product productToOrder) {

	setQuantity(quantity);
	this.delivered = delivered;
	this.user = user;
	this.orderFrmShop = orderFrmShop;
	this.productToOrder = productToOrder;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	if (quantity <= 0)
	    throw new IllegalArgumentException("Invalid quantity value.");
	this.quantity = quantity;
    }

    public boolean isDelivered() {
	return delivered;
    }

    public void setDelivered(boolean delivered) {
	this.delivered = delivered;
    }

}

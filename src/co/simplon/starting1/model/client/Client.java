/**
 * Client hérite de Entity, afin que chaque instance de Client possède 
 * un Id (signature) unique de type String,
 * afin de faciliter la gestion des repo.  
 */
package co.simplon.starting1.model.client;

import java.util.Objects;

import co.simplon.starting1.model.common.Entity;
import co.simplon.starting1.model.product.Product;
import co.simplon.starting1.model.shop.Shop;

public class Client extends Entity {

    private static final long serialVersionUID = 1L;

    private String name;

    private float credit;

    public Client(String name, float credit) {
	// Appel des Setters, car y'a des tests de param(name+credit)
	setName(name);
	setCredit(credit);
    }
//  Methode demandé lors de la première version du Diagramme de class shop
//
//    public float buySomething(Shop shop, Product product, int quantity) {
//
//	float ttc;
//	ttc = product.getSellingPrice() * (float) (quantity);
//	shop.sellProduct(product, quantity);
//	return ttc;
//    }

    public String getName() {

	return name;
    }

    public void setName(String name) {
	// param-name ne peut pas être vide  
	if (name.isEmpty())
	    throw new IllegalArgumentException("Empty name not allowed");

	this.name = name;
    }

    public float getCredit() {

	return credit;
    }

    public void setCredit(float credit) {
	// param-credit ne peut pas être négatif
	if (credit < 0)
	    throw new IllegalArgumentException("Negative values not allowed");

	this.credit = credit;
    }

    @Override
    public String toString() {

	return "Client [name : " + getName() + ", Credit : " + getCredit() + " ]";
    }

    @Override
    public boolean equals(Object obj) {
	// idem que obj == null
	if (Objects.isNull(obj))
	    return false;
	
	Client ClientToCheck = (Client) obj;
	return ClientToCheck.getName().equals(this.name) && ClientToCheck.getCredit() == this.credit ? true : false;
    }
}

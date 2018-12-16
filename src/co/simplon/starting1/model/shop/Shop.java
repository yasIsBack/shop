package co.simplon.starting1.model.shop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import co.simplon.starting1.model.common.Entity;
import co.simplon.starting1.model.product.Product;

public class Shop extends Entity {
    private static final long serialVersionUID = 1L;

    private HashSet<Stock> stock = new HashSet<>();

    private String name;

    private float stockValue; // La valeur marchande des stock

    private float turnover; // Le chiffre d'affaires // =PrixDeVente*quantitésVendues

    private float profit; // = stockValue - turnover

    public Shop(String name) {

	setName(name);
	this.stockValue = 0;
	this.turnover = 0;
	this.profit = 0;
    }

    /**
     * @return the name
     */
    public String getName() {

	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {

	if (name.isEmpty())
	    throw new IllegalArgumentException("Empty name not allowed !");

	this.name = name;
    }

    /**
     * @return the stockValue
     */
    public float getStockValue() {

	return stockValue;
    }

    /**
     * @param stockValue the stockValue to set
     */
    public void setStockValue(float stockValue) {

	if (stockValue < 0)
	    throw new IllegalArgumentException("Not accepting negative OR zero numbers");
	this.stockValue = stockValue;
    }

    /**
     * @return the turnover
     */
    public float getTurnover() {

	return turnover;
    }

    /**
     * @param turnover the turnover to set
     */
    public void setTurnover(float turnover) {

	if (turnover < 0)
	    throw new IllegalArgumentException("Not accepting negative OR zero numbers");
	this.turnover = turnover;
    }

    /**
     * @return the profit
     */
    public float getProfit() {

	return profit;
    }

    /**
     * @param profit the profit to set
     */
    public void setProfit(float profit) {

	if (profit < 0)
	    throw new IllegalArgumentException("Not accepting negative OR zero numbers");
	this.profit = profit;
    }

    public void addProductToStock(Stock stock) {

	this.stock.add(stock);

    }

    public List<Stock> getStock() {

	//return Collections.unmodifiableCollection(stock);
	return new ArrayList<Stock>(stock);
	// return (List<Product>) Collections.unmodifiableCollection(stock);

    }

    /*
     * Vendre des produits
     */
    public void sellProduct(Product product, int quantity) {

	if (Objects.isNull(product) || (quantity == 0))
	    throw new IllegalArgumentException("Product is null OR quantity value equal to zero.");

	for (Stock s : stock) {
	    if (s.getProduct().equals(product)) {
		if (!s.inStock() && !s.canIOrderQTY(quantity))
		    System.out.println("Product " + product.getName() + ", we are currently out of stock");

		else {

		    turnOverCalculate(product, quantity);
		    int updateStockQTY = (s.getQuantity() - quantity);
		    s.setQuantity(updateStockQTY);
		    stocksValueCalculate();
		    profitCalculate();
		}
	    }
	} // END FOREACH
    }

    private void stocksValueCalculate() {

	float tmpStocksValue = 0;
	for (Stock s : stock) {
	    tmpStocksValue += s.getQuantity() * s.getProduct().getBuyingPrice();
	}
	setStockValue(tmpStocksValue);
    }

    private void turnOverCalculate(Product pSold, int qty) {

	float tmpTurnOver = pSold.getSellingPrice() * qty;
	setTurnover(tmpTurnOver);
    }

    private void profitCalculate() {

	float tempProfit = getStockValue() - getTurnover();
	setProfit(tempProfit);
    }

    @Override
    public String toString() {

	return "Shope name : " + getName() + "\nStock Value : " + getStockValue() + "\nTurnover : " + getTurnover()
		+ "\nProfit : " + getProfit() + "\n";
    }

}

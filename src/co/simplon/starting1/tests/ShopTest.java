package co.simplon.starting1.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import co.simplon.starting1.model.product.Food;
import co.simplon.starting1.model.product.Product;
import co.simplon.starting1.model.shop.Shop;
import co.simplon.starting1.model.shop.Stock;

class ShopTest {

    @Test
    void testSellProduct() {

	Shop test = new Shop("1st-test");
	Product banane = new Food("Banane", 1, 2, false);
	Stock sBanane = new Stock(100, banane);
	test.addProductToStock(sBanane);

	test.sellProduct(banane, 5);
	assertEquals(95,sBanane.getQuantity());

    }

}

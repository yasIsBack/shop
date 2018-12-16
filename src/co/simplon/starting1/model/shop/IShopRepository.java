package co.simplon.starting1.model.shop;

import java.util.List;

import co.simplon.starting1.model.product.Product;

public interface IShopRepository {

    void saveShop(Shop shop);

    void deleteShop(Shop shop);

    List<Shop> getAllShops();

    List<Product> getProductsByShop(Shop shop);

    int getProductAvailability(Product product, Shop shop);

    void addProductsToShop(Product product, Shop shop, int quantity);

    List<Stock> getShopStocks(Shop shop);

}

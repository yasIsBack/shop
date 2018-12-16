package co.simplon.starting1.model.product;

import java.util.List;

public interface IProductRepository {

    void saveProduct(Product product);

    void deleteProduct(Product product);

    Product findById(String id);

    List<Product> getAllProducts();

}

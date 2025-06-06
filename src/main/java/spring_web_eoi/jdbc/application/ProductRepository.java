package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAllProducts();

    Product findProductById(String id);

    void saveProduct(Product product);
}

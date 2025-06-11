package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts();

    Optional<Product> findProductById(String id);

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(String id);
}

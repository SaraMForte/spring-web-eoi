package spring_web_eoi.jdbc.application;

import org.springframework.stereotype.Service;
import spring_web_eoi.jdbc.domain.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    public Optional<Product> findProductById(String id) {
        return Optional.ofNullable(productRepository.findProductById(id));
    }

    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteProduct(id);
    }
}
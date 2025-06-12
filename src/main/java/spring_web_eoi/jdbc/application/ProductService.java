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

    public List<Product> findAll() {
        return productRepository.findAllProducts();
    }

    public Optional<Product> findById(String id) {
        return Optional.ofNullable(productRepository.findProductById(id));
    }

    public void save(Product product) {
        productRepository.saveProduct(product);
    }

    public void update(Product product) {
        productRepository.updateProduct(product);
    }

    public void deleteById(String id) {
        productRepository.deleteProduct(id);
    }
}
package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.domain.ProductLine;

import java.util.List;
import java.util.Optional;

public class ProductLineService {

    ProductLineRepository productLineRepository;

    public ProductLineService(ProductLineRepository productLineRepository) {
        this.productLineRepository = productLineRepository;
    }

    public List<ProductLine> findAll() {
        return productLineRepository.findAllProductLines();
    }

    public Optional<ProductLine> findById(String id) {
        return productLineRepository.findProductLinetById(id);
    }

    public void save(ProductLine productLine) {
        productLineRepository.saveProductLine(productLine);
    }

    public void update(ProductLine productLine) {
        productLineRepository.updateProductLine(productLine);
    }

    public void deleteById(String id) {
        productLineRepository.deleteProductLine(id);
    }
}

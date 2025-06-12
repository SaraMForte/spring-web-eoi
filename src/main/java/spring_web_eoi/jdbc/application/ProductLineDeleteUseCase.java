package spring_web_eoi.jdbc.application;

public class ProductLineDeleteUseCase {

    private final ProductLineRepository productLineRepository;
    private final ProductRepository productRepository;

    public ProductLineDeleteUseCase(ProductLineRepository productLineRepository, ProductRepository productRepository) {
        this.productLineRepository = productLineRepository;
        this.productRepository = productRepository;
    }

    public void deleteProductLine(String productLineId) {
        productRepository.findAllProducts()
                .stream()
                .filter(product -> product.productLine().equals(productLineId))
                .forEach(product -> productRepository.deleteProduct(product.productCode()));

        productLineRepository.deleteProductLine(productLineId);
    }
}

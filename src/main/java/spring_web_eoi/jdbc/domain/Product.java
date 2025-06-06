package spring_web_eoi.jdbc.domain;

public class Product {
    private String productCode;
    private String name;
    private String productLine;
    private String dimensions;
    private String supplier;
    private String description;
    private int quantityInStock;
    private float salePrice;
    private float supplierPrice;

    public String productCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String productLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String dimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String supplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int quantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public float salePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float supplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(float supplierPrice) {
        this.supplierPrice = supplierPrice;
    }
}

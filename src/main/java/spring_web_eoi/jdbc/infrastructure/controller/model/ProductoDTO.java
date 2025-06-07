package spring_web_eoi.jdbc.infrastructure.controller.model;

import spring_web_eoi.jdbc.domain.Product;

public class ProductoDTO {
    private String codigoProducto;
    private String nombre;
    private String gama;
    private String dimensiones;
    private String proveedor;
    private String descripcion;
    private int cantidadEnStock;
    private float precioVenta;
    private float precioProveedor;

    public static ProductoDTO fromDomain(Product product) {
        ProductoDTO dto = new ProductoDTO();
        dto.setCodigoProducto(product.productCode());
        dto.setNombre(product.name());
        dto.setGama(product.productLine());
        dto.setDimensiones(product.dimensions());
        dto.setProveedor(product.supplier());
        dto.setDescripcion(product.description());
        dto.setCantidadEnStock(product.quantityInStock());
        dto.setPrecioVenta(product.salePrice());
        dto.setPrecioProveedor(product.supplierPrice());
        return dto;
    }

    public Product toDomain() {
        Product product = new Product();
        product.setProductCode(codigoProducto);
        product.setName(nombre);
        product.setProductLine(gama);
        product.setDimensions(dimensiones);
        product.setSupplier(proveedor);
        product.setDescription(descripcion);
        product.setQuantityInStock(cantidadEnStock);
        product.setSalePrice(precioVenta);
        product.setSupplierPrice(precioProveedor);
        return product;
    }

    public boolean isEmpty() {
        return codigoProducto == null || nombre == null || gama == null || dimensiones == null || proveedor == null || descripcion == null;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
               "codigoProducto='" + codigoProducto + '\'' +
               ", nombre='" + nombre + '\'' +
               ", gama='" + gama + '\'' +
               ", dimensiones='" + dimensiones + '\'' +
               ", proveedor='" + proveedor + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", cantidadEnStock=" + cantidadEnStock +
               ", precioVenta=" + precioVenta +
               ", precioProveedor=" + precioProveedor +
               '}';
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(float precioProveedor) {
        this.precioProveedor = precioProveedor;
    }
}


package spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import spring_web_eoi.jdbc.domain.Product;

@Table("producto")
public class ProductoJDBC {

    @Id
    private String codigoProducto;
    private String nombre;
    private String gama;
    private String dimensiones;
    private String proveedor;
    private String descripcion;
    private int cantidadEnStock;
    private float precioVenta;
    private float precioProveedor;

    public String codigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String nombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String gama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String dimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String proveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String descripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int cantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public float precioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float precioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(float precioProveedor) {
        this.precioProveedor = precioProveedor;
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
}

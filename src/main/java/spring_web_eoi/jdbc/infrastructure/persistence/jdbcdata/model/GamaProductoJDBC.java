package spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import spring_web_eoi.jdbc.domain.ProductLine;

@Table("gama_producto")
public class GamaProductoJDBC {
    @Id
    private String gama;
    private String descripcionTexto;
    private String descripcionHtml;
    private String imagen;

    public String gama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String descripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String descripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String imagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ProductLine toDomain() {
        ProductLine productLine = new ProductLine();
        productLine.setLine(gama);
        productLine.setTextDescription(descripcionTexto);
        productLine.setHtmlDescription(descripcionHtml);
        productLine.setImage(imagen);
        return productLine;
    }

    public static GamaProductoJDBC fromDomain(ProductLine productLine) {
        GamaProductoJDBC gamaProductoJDBC = new GamaProductoJDBC();
        gamaProductoJDBC.setGama(productLine.line());
        gamaProductoJDBC.setDescripcionTexto(productLine.textDescription());
        gamaProductoJDBC.setDescripcionHtml(productLine.htmlDescription());
        gamaProductoJDBC.setImagen(productLine.image());
        return gamaProductoJDBC;
    }
}

package spring_web_eoi.jdbc.infrastructure.controller.model;

import spring_web_eoi.jdbc.domain.ProductLine;

public class GamaProductoDTO {
    private String gama;
    private String descripcionTexto;
    private String descripcionHtml;
    private String imagen;

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getDescripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String getImagen() {
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

    public static GamaProductoDTO fromDomain(ProductLine productLine) {
        GamaProductoDTO gamaProductoDTO = new GamaProductoDTO();
        gamaProductoDTO.setGama(productLine.line());
        gamaProductoDTO.setDescripcionTexto(productLine.textDescription());
        gamaProductoDTO.setDescripcionHtml(productLine.htmlDescription());
        gamaProductoDTO.setImagen(productLine.image());
        return gamaProductoDTO;
    }
}

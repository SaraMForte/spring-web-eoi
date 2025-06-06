package spring_web_eoi.jdbc.infrastructure.persistence.jdbc.model;

import org.springframework.jdbc.core.RowMapper;
import spring_web_eoi.jdbc.domain.Office;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OficinaTable implements RowMapper<OficinaTable> {
    private String codigoOficina;
    private String ciudad;
    private String pais;
    private String region;
    private String codigoPostal;
    private String telefono;
    private String lineaDireccion1;
    private String lineaDireccion2;

    public String codigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String ciudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String pais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String region() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String codigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String telefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String lineaDireccion1() {
        return lineaDireccion1;
    }

    public void setLineaDireccion1(String lineaDireccion1) {
        this.lineaDireccion1 = lineaDireccion1;
    }

    public String lineaDireccion2() {
        return lineaDireccion2;
    }

    public void setLineaDireccion2(String lineaDireccion2) {
        this.lineaDireccion2 = lineaDireccion2;
    }

    public Office toOffice() {
        Office office = new Office();
        office.setOfficeCode(codigoOficina);
        office.setCity(ciudad);
        office.setCountry(pais);
        office.setRegion(region);
        office.setPostalCode(codigoPostal);
        office.setPhone(telefono);
        office.setAddressLine1(lineaDireccion1);
        office.setAddressLine2(lineaDireccion2);
        return office;
    }

    @Override
    public OficinaTable mapRow(ResultSet rs, int rowNum) throws SQLException {
        OficinaTable oficinaTable = new OficinaTable();
        oficinaTable.setCodigoOficina(rs.getString("codigo_oficina"));
        oficinaTable.setCiudad(rs.getString("ciudad"));
        oficinaTable.setPais(rs.getString("pais"));
        oficinaTable.setRegion(rs.getString("region"));
        oficinaTable.setCodigoPostal(rs.getString("codigo_postal"));
        oficinaTable.setTelefono(rs.getString("telefono"));
        oficinaTable.setLineaDireccion1(rs.getString("linea_direccion1"));
        oficinaTable.setLineaDireccion2(rs.getString("linea_direccion2"));
        return oficinaTable;
    }

    @Override
    public String toString() {
        return "Oficina{" +
               "codigo_oficina='" + codigoOficina + '\'' +
               ", ciudad='" + ciudad + '\'' +
               ", pais='" + pais + '\'' +
               ", region='" + region + '\'' +
               ", codigo_postal='" + codigoPostal + '\'' +
               ", telefono='" + telefono + '\'' +
               ", linea_direccion1='" + lineaDireccion1 + '\'' +
               ", linea_direccion2='" + lineaDireccion2 + '\'' +
               '}';
    }
}

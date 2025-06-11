package spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import spring_web_eoi.jdbc.domain.Client;

@Table("cliente")
public class ClienteJDBC {

    @Id
    private int codigoCliente;
    private String nombreCliente;
    private String nombreContacto;
    private String apellidoContacto;
    private String telefono;
    private String fax;
    private String lineaDireccion1;
    private String lineaDireccion2;
    private String ciudad;
    private String region;
    private String pais;
    private String codigoPostal;
    private int codigoEmpleadoRepVentas;
    private double limiteCredito;

    public int codigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String nombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String nombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String apellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public String telefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String fax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public String ciudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String region() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String pais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String codigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int codigoEmpleadoRepVentas() {
        return codigoEmpleadoRepVentas;
    }

    public void setCodigoEmpleadoRepVentas(int codigoEmpleadoRepVentas) {
        this.codigoEmpleadoRepVentas = codigoEmpleadoRepVentas;
    }

    public double limiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Client toDomain() {
        Client client = new Client();
        client.setClientCode(codigoCliente);
        client.setFirstName(nombreCliente);
        client.setContactName(nombreContacto);
        client.setContactLastName(apellidoContacto);
        client.setContactPhone(telefono);
        client.setFax(fax);
        client.setAddressLine1(lineaDireccion1);
        client.setAddressLine2(lineaDireccion2);
        client.setCity(ciudad);
        client.setRegion(region);
        client.setCountry(pais);
        client.setPostalCode(codigoPostal);
        client.setEmployeeSalesRepresentativeCode(codigoEmpleadoRepVentas);
        client.setCreditLimit(limiteCredito);
        return client;
    }
}

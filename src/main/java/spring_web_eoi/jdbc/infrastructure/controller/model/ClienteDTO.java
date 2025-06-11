package spring_web_eoi.jdbc.infrastructure.controller.model;

import spring_web_eoi.jdbc.domain.Client;

import java.util.Objects;

public class ClienteDTO {
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

    public ClienteDTO() {
    }

    public ClienteDTO(int codigoCliente, String nombreCliente, String nombreContacto, String apellidoContacto, String telefono, String fax, String lineaDireccion1, String lineaDireccion2, String ciudad, String region, String pais, String codigoPostal, int codigoEmpleadoRepVentas, double limiteCredito) {
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefono = telefono;
        this.fax = fax;
        this.lineaDireccion1 = lineaDireccion1;
        this.lineaDireccion2 = lineaDireccion2;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.codigoEmpleadoRepVentas = codigoEmpleadoRepVentas;
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

    public static ClienteDTO fromDomain(Client client) {
        return new ClienteDTO(
                client.clientCode(),
                client.firstName(),
                client.contactName(),
                client.contactLastName(),
                client.contactPhone(),
                client.fax(),
                client.addressLine1(),
                client.addressLine2(),
                client.city(),
                client.region(),
                client.country(),
                client.postalCode(),
                client.employeeSalesRepresentativeCode(),
                client.creditLimit()
        );
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLineaDireccion1() {
        return lineaDireccion1;
    }

    public void setLineaDireccion1(String lineaDireccion1) {
        this.lineaDireccion1 = lineaDireccion1;
    }

    public String getLineaDireccion2() {
        return lineaDireccion2;
    }

    public void setLineaDireccion2(String lineaDireccion2) {
        this.lineaDireccion2 = lineaDireccion2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getCodigoEmpleadoRepVentas() {
        return codigoEmpleadoRepVentas;
    }

    public void setCodigoEmpleadoRepVentas(int codigoEmpleadoRepVentas) {
        this.codigoEmpleadoRepVentas = codigoEmpleadoRepVentas;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ClienteDTO) obj;
        return this.codigoCliente == that.codigoCliente &&
               Objects.equals(this.nombreCliente, that.nombreCliente) &&
               Objects.equals(this.nombreContacto, that.nombreContacto) &&
               Objects.equals(this.apellidoContacto, that.apellidoContacto) &&
               Objects.equals(this.telefono, that.telefono) &&
               Objects.equals(this.fax, that.fax) &&
               Objects.equals(this.lineaDireccion1, that.lineaDireccion1) &&
               Objects.equals(this.lineaDireccion2, that.lineaDireccion2) &&
               Objects.equals(this.ciudad, that.ciudad) &&
               Objects.equals(this.region, that.region) &&
               Objects.equals(this.pais, that.pais) &&
               Objects.equals(this.codigoPostal, that.codigoPostal) &&
               Objects.equals(this.codigoEmpleadoRepVentas, that.codigoEmpleadoRepVentas) &&
               Objects.equals(this.limiteCredito, that.limiteCredito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCliente, nombreCliente, nombreContacto, apellidoContacto, telefono, fax, lineaDireccion1, lineaDireccion2, ciudad, region, pais, codigoPostal, codigoEmpleadoRepVentas, limiteCredito);
    }

    @Override
    public String toString() {
        return "ClienteDTO[" +
               "codigoCliente=" + codigoCliente + ", " +
               "nombreCliente=" + nombreCliente + ", " +
               "nombreContacto=" + nombreContacto + ", " +
               "apellidoContacto=" + apellidoContacto + ", " +
               "telefono=" + telefono + ", " +
               "fax=" + fax + ", " +
               "lineaDireccion1=" + lineaDireccion1 + ", " +
               "lineaDireccion2=" + lineaDireccion2 + ", " +
               "ciudad=" + ciudad + ", " +
               "region=" + region + ", " +
               "pais=" + pais + ", " +
               "codigoPostal=" + codigoPostal + ", " +
               "codigoEmpleadoRepVentas=" + codigoEmpleadoRepVentas + ", " +
               "limiteCredito=" + limiteCredito + ']';
    }

}

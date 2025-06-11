package spring_web_eoi.jdbc.domain;

public class Client {
    private int clientCode;
    private String firstName;
    private String contactName;
    private String contactLastName;
    private String contactPhone;
    private String fax;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String region;
    private String country;
    private String postalCode;
    private int employeeSalesRepresentativeCode;
    private double creditLimit;

    public int clientCode() {
        return clientCode;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
    }

    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String contactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String contactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String contactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String fax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String addressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String addressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String city() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String region() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String country() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String postalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int employeeSalesRepresentativeCode() {
        return employeeSalesRepresentativeCode;
    }

    public void setEmployeeSalesRepresentativeCode(int employeeSalesRepresentativeCode) {
        this.employeeSalesRepresentativeCode = employeeSalesRepresentativeCode;
    }

    public double creditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Client{" +
               "clientCode=" + clientCode +
               ", firstName='" + firstName + '\'' +
               ", contactName='" + contactName + '\'' +
               ", contactLastName='" + contactLastName + '\'' +
               ", contactPhone='" + contactPhone + '\'' +
               ", fax='" + fax + '\'' +
               ", addressLine1='" + addressLine1 + '\'' +
               ", addressLine2='" + addressLine2 + '\'' +
               ", city='" + city + '\'' +
               ", region='" + region + '\'' +
               ", country='" + country + '\'' +
               ", postalCode='" + postalCode + '\'' +
               ", employeeSalesRepresentativeCode=" + employeeSalesRepresentativeCode +
               ", creditLimit=" + creditLimit +
               '}';
    }
}

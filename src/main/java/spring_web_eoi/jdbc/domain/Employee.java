package spring_web_eoi.jdbc.domain;

public class Employee {
    private int employeeCode;
    private String firstName;
    private String lastName1;
    private String lastName2;
    private String extension;
    private String email;
    private Office office;
    private int managerCode;
    private String jobTitle;

    public int employeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String lastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String lastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String extension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Office office() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public int managerCode() {
        return managerCode;
    }

    public void setManagerCode(int managerCode) {
        this.managerCode = managerCode;
    }

    public String jobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}

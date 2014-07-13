package model.beans;

import java.sql.Timestamp;

public class Researcher {
    private int id;
    private String username;
    private String password;
    private Device device;
    private String status;
    private String firstname;
    private String lastname;
    private String address;
    private String country;
    private String phone;
    private String state;
    private String zip;
    private Timestamp lastlogin;

    public Researcher() {}

    public Researcher(int id, String username, String password, Device device, String status, String firstname, String lastname, String address, String country, String phone, String state, String zip, Timestamp lastlogin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.device = device;
        this.status = status;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.country = country;
        this.phone = phone;
        this.state = state;
        this.zip = zip;
        this.lastlogin = lastlogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Timestamp getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Timestamp lastlogin) {
        this.lastlogin = lastlogin;
    }
}

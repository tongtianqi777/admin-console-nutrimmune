package model.beans.csv;

import model.beans.Researcher;

import java.sql.Timestamp;

public class ResearcherCSV {

    private int id;
    private String username;
    private String password;
    private int deviceId;
    private String status;
    private String firstname;
    private String lastname;
    private String address;
    private String country;
    private String phone;
    private String state;
    private String zip;
    private Timestamp lastlogin;

    public ResearcherCSV(Researcher researcher) {
        this.id = researcher.getId();
        this.username = researcher.getUsername();
        this.password = researcher.getPassword();
        this.deviceId = researcher.getDevice().getId();
        this.status = researcher.getStatus();
        this.firstname = researcher.getFirstname();
        this.lastname = researcher.getLastname();
        this.address = researcher.getAddress();
        this.country = researcher.getCountry();
        this.phone = researcher.getPhone();
        this.state = researcher.getState();
        this.zip = researcher.getZip();
        this.lastlogin = researcher.getLastlogin();
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

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
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

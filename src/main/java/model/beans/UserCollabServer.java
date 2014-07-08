package model.beans;

import java.sql.Timestamp;
import java.util.List;

/**
 * Author: shim.
 * Creation date: 4/18/14.
 */
public class UserCollabServer {
    private int id;
    private String login;
    private String address;
    private String affiliation;
    private String phone;
    private String country;
    private String firstname;
    private Timestamp lastlogin;
    private String lastname;
    private String password;
    private String state;
    private String timezone;
    private int zip;
    private List<String> role;
    private String token;
    private Timestamp expiry;
    private String remote;
    private String status;

    public UserCollabServer() {
    }

    public UserCollabServer(int id, String login, String address, String affiliation, String phone, String country, String firstname, Timestamp lastlogin, String lastname, String password, String state, String timezone, int zip, List<String> role, String token, Timestamp expiry, String remote, String status) {
        this.id = id;
        this.login = login;
        this.address = address;
        this.affiliation = affiliation;
        this.phone = phone;
        this.country = country;
        this.firstname = firstname;
        this.lastlogin = lastlogin;
        this.lastname = lastname;
        this.password = password;
        this.state = state;
        this.timezone = timezone;
        this.zip = zip;
        this.role = role;
        this.token = token;
        this.expiry = expiry;
        this.remote = remote;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Timestamp getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Timestamp lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getExpiry() {
        return expiry;
    }

    public void setExpiry(Timestamp expiry) {
        this.expiry = expiry;
    }

    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

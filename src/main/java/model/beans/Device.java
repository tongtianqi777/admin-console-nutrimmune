package model.beans;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Author: Rix
 * Creation date: 7/12/14.
 */
public class Device {
    private int id;
    private String mac;
    private String manufacturedat;
    private Date manufactureddate;
    private String osbuildrev;
    private String owner;
    private Date shipdate;
    private String status;

    public Device() {
    }

    public Device(int id, String mac, String manufacturedat, Date manufactureddate, String osbuildrev, String owner, Date shipdate, String status) {
        this.id = id;
        this.mac = mac;
        this.manufacturedat = manufacturedat;
        this.manufactureddate = manufactureddate;
        this.osbuildrev = osbuildrev;
        this.owner = owner;
        this.shipdate = shipdate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMac() { return mac; }

    public String getManufacturedat() {
        return manufacturedat;
    }

    public void setManufacturedat(String manufacturedat) {
        this.manufacturedat = manufacturedat;
    }

    public Date getManufactureddate() {
        return manufactureddate;
    }

    public void setManufactureddate(Date manufactureddate) {
        this.manufactureddate = manufactureddate;
    }

    public String getOsbuildrev() {
        return osbuildrev;
    }

    public void setOsbuildrev(String osbuildrev) {
        this.osbuildrev = osbuildrev;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

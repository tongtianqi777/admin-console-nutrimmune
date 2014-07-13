package model.beans;

import java.util.Date;

public class Device {
    private int id;
    private String mac;
    private String manuAddr;
    private Date manuDate;
    private Date shipDate;
    private String ownerName;
    private String status;
    private Community community;

    public Device() {}

    public Device(int id, String mac, String manuAddr, Date manuDate, Date shipDate, String ownerName, String status, Community community) {
        this.id = id;
        this.mac = mac;
        this.manuAddr = manuAddr;
        this.manuDate = manuDate;
        this.shipDate = shipDate;
        this.ownerName = ownerName;
        this.status = status;
        this.community = community;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getManuAddr() {
        return manuAddr;
    }

    public void setManuAddr(String manuAddr) {
        this.manuAddr = manuAddr;
    }

    public Date getManuDate() {
        return manuDate;
    }

    public void setManuDate(Date manuDate) {
        this.manuDate = manuDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}

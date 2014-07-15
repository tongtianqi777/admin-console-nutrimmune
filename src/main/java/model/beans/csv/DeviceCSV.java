package model.beans.csv;


import model.beans.Device;

import java.util.Date;

public class DeviceCSV {

    private int id;
    private String mac;
    private String manuAddr;
    private Date manuDate;
    private Date shipDate;
    private String ownerName;
    private String status;
    private int communityId;

    public DeviceCSV (Device device) {
        this.id = device.getId();
        this.mac = device.getMac();
        this.manuAddr = device.getManuAddr();
        this.manuDate = device.getManuDate();
        this.shipDate = device.getShipDate();
        this.ownerName = device.getOwnerName();
        this.status = device.getStatus();
        this.communityId = device.getCommunity().getId();
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

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }
}

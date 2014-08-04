package controller.forms;

public class DeviceForm {

    private int id;
    private String mac;
    private int osbuildrev;
    private int ownerId;
    private String status;

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

    public int getOsbuildrev() {
        return osbuildrev;
    }

    public void setOsbuildrev(int osbuildrev) {
        this.osbuildrev = osbuildrev;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

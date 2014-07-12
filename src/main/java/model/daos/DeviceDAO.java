package model.daos;

import model.beans.ConnectionFactory;
import model.beans.DbUtil;
import model.beans.Device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Rix on 7/12/14.
 */
public class DeviceDAO {


    private Connection connection;
    private PreparedStatement preparedStatement;

    public Device getDevice(String mac) throws SQLException {
        ResultSet rs = null;
        Device device = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from devices where mac=?");
            preparedStatement.setString(1, mac);
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();
            device = new Device();
            while (rs.next()) {
                device.setId(rs.getInt("id"));
                device.setMac(rs.getString("mac"));
                device.setManufacturedat(rs.getString("manufacturdat"));
                device.setManufactureddate(rs.getDate("manufactureddate"));
                device.setOsbuildrev(rs.getString("osbuildrev"));
                device.setOwner(rs.getString("owner"));
                device.setShipdate(rs.getDate("shipdate"));
                device.setStatus(rs.getString("status"));
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return device;
    }


    public ArrayList<Device> getDevices() throws SQLException {
        ResultSet rs = null;
        ArrayList<Device> deviceList = new ArrayList<Device>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from devices");
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();
            while (rs.next()) {
                Device device = new Device();

                device.setId(rs.getInt("id"));
                device.setMac(rs.getString("mac"));
                device.setManufacturedat(rs.getString("manufacturdat"));
                device.setManufactureddate(rs.getDate("manufactureddate"));
                device.setOsbuildrev(rs.getString("osbuildrev"));
                device.setOwner(rs.getString("owner"));
                device.setShipdate(rs.getDate("shipdate"));
                device.setStatus(rs.getString("status"));

                deviceList.add(device);
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return deviceList;
    }
}



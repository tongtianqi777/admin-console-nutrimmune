package model.daos;

import utils.ConnectionFactory;
import utils.DbUtil;
import model.beans.Device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DeviceDAO {


    private Connection connection;
    private PreparedStatement preparedStatement;
    private CommunityDAO communityDAO = new CommunityDAO();

    public Device getDevice(String mac) throws SQLException {
        ResultSet rs = null;
        Device d = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from devices where mac=?");
            preparedStatement.setString(1, mac);
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();

            while (rs.next()) {
                d = parseResult(rs);
            }

        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return d;
    }

    public Device getDevice (int id) throws SQLException {
        ResultSet rs = null;
        Device d = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from devices where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();

            while (rs.next()) {
                d = parseResult(rs);
            }

        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return d;
    }


    public ArrayList<Device> getAllDevices() throws SQLException {
        ResultSet rs = null;
        ArrayList<Device> deviceList = new ArrayList<Device>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from device");
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();

            while (rs.next()) {
                Device d = parseResult(rs);
                deviceList.add(d);
            }

        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return deviceList;
    }

    private Device parseResult(ResultSet rs) throws SQLException {
        Device d = new Device(
                rs.getInt("id"),
                rs.getString("mac"),
                rs.getString("manu_addr"),
                rs.getDate("manu_date"),
                rs.getDate("ship_date"),
                rs.getString("owner_name"),
                rs.getString("status"),
                communityDAO.getCommunity(rs.getInt("community"))
        );

        return d;
    }
}



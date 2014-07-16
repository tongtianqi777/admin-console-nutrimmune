package model.daos;

import model.beans.csv.DeviceCSV;
import utils.ConnectionFactory;
import utils.DbUtil;
import model.beans.Device;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DeviceDAO {


    private Connection connection;
    private PreparedStatement preparedStatement;
    private CommunityDAO communityDAO = new CommunityDAO();

    public Device getDevice(String mac) throws SQLException {
        ResultSet rs = null;
        Device d = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from device where mac=?");
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
            preparedStatement = connection.prepareCall("select * from device where id=?");
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

    public void importCSV(List<DeviceCSV> deviceCSVs) throws SQLException {
        try {
            for (DeviceCSV d : deviceCSVs) {
                if (exist(d.getId())) {
                    update(d);

                } else {
                    insert(d);
                }
            }

        } finally {
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
    }

    private void insert(DeviceCSV d) throws SQLException {
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "insert into device values " +
                        "(?, ?, ?, ?, ?, ?, ?, ?);"
        );
        preparedStatement.setInt(1, d.getId());
        preparedStatement.setString(2, d.getMac());
        preparedStatement.setString(3, d.getManuAddr());
        preparedStatement.setDate(4, new Date(d.getManuDate().getTime()));
        preparedStatement.setDate(5, new Date(d.getShipDate().getTime()));
        preparedStatement.setString(6, d.getOwnerName());
        preparedStatement.setString(7, d.getStatus());
        preparedStatement.setInt(8, d.getCommunityId());
        preparedStatement.execute();
    }

    private void update(DeviceCSV d) throws SQLException {
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "update device set" +
                        " mac = ?," +
                        " manu_addr = ?," +
                        " manu_date = ?," +
                        " ship_date = ?," +
                        " owner_name = ?," +
                        " status = ?," +
                        " community = ?" +
                        " where id = ?;"
        );

        preparedStatement.setString(1, d.getMac());
        preparedStatement.setString(2, d.getManuAddr());
        preparedStatement.setDate(3, new Date(d.getManuDate().getTime()));
        preparedStatement.setDate(4, new Date(d.getShipDate().getTime()));
        preparedStatement.setString(5, d.getOwnerName());
        preparedStatement.setString(6, d.getStatus());
        preparedStatement.setInt(7, d.getCommunityId());
        preparedStatement.setInt(8, d.getId());
        preparedStatement.execute();
    }

    private boolean exist(int id) throws SQLException {
        return getDevice(id) != null;
    }
}



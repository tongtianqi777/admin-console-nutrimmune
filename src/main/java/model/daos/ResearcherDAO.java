package model.daos;

import model.beans.Researcher;
import utils.ConnectionFactory;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResearcherDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private DeviceDAO deviceDAO = new DeviceDAO();

    public Researcher getResearcher(String username) throws SQLException {
        ResultSet rs = null;
        Researcher r = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from researcher where username=?");
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();

            while (rs.next()) {
                r = parseResultSet(rs);
            }

        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return r;
    }

    public Researcher getResearcher(int id) throws SQLException {
        ResultSet rs = null;
        Researcher r = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from researcher where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();

            while (rs.next()) {
                r = parseResultSet(rs);
            }

        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return r;
    }

    public ArrayList<Researcher> getAllResearchers() throws SQLException {
        ResultSet rs = null;
        ArrayList<Researcher> researchers = new ArrayList<Researcher>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from researcher");
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();

            while (rs.next()) {
                Researcher r = parseResultSet(rs);
                researchers.add(r);
            }

        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return researchers;
    }

    private Researcher parseResultSet(ResultSet rs) throws SQLException {
        Researcher r = new Researcher(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                deviceDAO.getDevice(rs.getInt("device")),
                rs.getString("status"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("address"),
                rs.getString("country"),
                rs.getString("phone"),
                rs.getString("state"),
                rs.getString("zip_code"),
                rs.getTimestamp("last_login")
        );

        return r;
    }
}
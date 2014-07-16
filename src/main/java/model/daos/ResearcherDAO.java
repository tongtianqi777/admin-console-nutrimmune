package model.daos;

import model.beans.Researcher;
import model.beans.csv.ResearcherCSV;
import utils.ConnectionFactory;
import utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Researcher> getAllResearchers() throws SQLException {
        ResultSet rs = null;
        List<Researcher> researchers = new ArrayList<Researcher>();
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

    public boolean exist (int id) throws SQLException {
        return getResearcher(id) != null;
    }

    public void importCSV(List<ResearcherCSV> researcherCSVs) throws SQLException {
        try {
            for (ResearcherCSV r : researcherCSVs) {
                if (exist(r.getId())) {
                    update(r);

                } else {
                    insert(r);
                }
            }

        } finally {
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
    }

    private void insert(ResearcherCSV r) throws SQLException {
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "insert into researcher values " +
                        "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
        );
        preparedStatement.setInt(1, r.getId());
        preparedStatement.setString(2, r.getUsername());
        preparedStatement.setString(3, r.getPassword());
        preparedStatement.setInt(4, r.getDeviceId());
        preparedStatement.setString(5, r.getStatus());
        preparedStatement.setString(6, r.getFirstname());
        preparedStatement.setString(7, r.getLastname());
        preparedStatement.setString(8, r.getAddress());
        preparedStatement.setString(9, r.getCountry());
        preparedStatement.setString(10, r.getPhone());
        preparedStatement.setString(11, r.getState());
        preparedStatement.setString(12, r.getZip());
        preparedStatement.setTimestamp(13, Timestamp.valueOf(r.getLastlogin()));
        preparedStatement.execute();
    }

    private void update (ResearcherCSV r) throws SQLException {
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "update researcher set" +
                        " username = ?," +
                        " password = ?," +
                        " device = ?," +
                        " status = ?," +
                        " first_name = ?," +
                        " last_name = ?," +
                        " address = ?," +
                        " country = ?," +
                        " phone = ?," +
                        " state = ?," +
                        " zip_code = ?," +
                        " last_login = ?" +
                        " where id = ?;"
        );
        preparedStatement.setString(1, r.getUsername());
        preparedStatement.setString(2, r.getPassword());
        preparedStatement.setInt(3, r.getDeviceId());
        preparedStatement.setString(4, r.getStatus());
        preparedStatement.setString(5, r.getFirstname());
        preparedStatement.setString(6, r.getLastname());
        preparedStatement.setString(7, r.getAddress());
        preparedStatement.setString(8, r.getCountry());
        preparedStatement.setString(9, r.getPhone());
        preparedStatement.setString(10, r.getState());
        preparedStatement.setString(11, r.getZip());
        preparedStatement.setTimestamp(12, Timestamp.valueOf(r.getLastlogin()));
        preparedStatement.setInt(13, r.getId());
        preparedStatement.execute();
    }
}
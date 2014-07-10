package model.daos;

import model.beans.ConnectionFactory;
import model.beans.DbUtil;
import model.beans.UserCollabServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: shim.
 * Creation date: 4/18/14.
 */
public class UserDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserCollabServer getUser(String login) throws SQLException {
        ResultSet rs = null;
        UserCollabServer user = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from users where login=?");
            preparedStatement.setString(1, login);
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();
            user = new UserCollabServer();
            while (rs.next()) {
                user.setAddress(rs.getString("address"));
                user.setAffiliation(rs.getString("affiliation"));
                user.setCountry(rs.getString("country"));
                user.setExpiry(rs.getTimestamp("expiry"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastlogin(rs.getTimestamp("lastlogin"));
                user.setLastname(rs.getString("lastname"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRemote(rs.getString("remote"));
                user.setRole(Arrays.asList(rs.getString("role").split(",")));
                user.setState(rs.getString("state"));
                user.setStatus(rs.getString("status"));
                user.setTimezone(rs.getString("timezone"));
                user.setToken(rs.getString("token"));
                user.setZip(rs.getInt("zip"));
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return user;
    }


    public ArrayList<UserCollabServer> getUsers() throws SQLException {
        ResultSet rs = null;
        ArrayList<UserCollabServer> userList = new ArrayList<UserCollabServer>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from users");
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();
            while (rs.next()) {
                UserCollabServer user = new UserCollabServer();

                user.setAddress(rs.getString("address"));
                user.setAffiliation(rs.getString("affiliation"));
                user.setCountry(rs.getString("country"));
                user.setExpiry(rs.getTimestamp("expiry"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastlogin(rs.getTimestamp("lastlogin"));
                user.setLastname(rs.getString("lastname"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRemote(rs.getString("remote"));
                user.setRole(Arrays.asList(rs.getString("role").split(",")));
                user.setState(rs.getString("state"));
                user.setStatus(rs.getString("status"));
                user.setTimezone(rs.getString("timezone"));
                user.setToken(rs.getString("token"));
                user.setZip(rs.getInt("zip"));

                userList.add(user);
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return userList;
    }
}
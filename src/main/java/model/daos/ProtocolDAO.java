package model.daos;

import model.beans.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: shim.
 * Creation date: 5/30/14.
 */
public class ProtocolDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public Protocol getProtocolById(int id) throws SQLException {
        Protocol protocol = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from protocols where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();
            protocol = convertResultSetToProtocol(rs);
        }
        finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }

        return protocol;
    }

    public void uploadProtocol(Protocol prot) throws SQLException {
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("INSERT INTO protocols (id, status, protocol, time_played) VALUES (nextval('protocols_id_seq'),? ,cast(? as json) ,?)");
            preparedStatement.setString(1, prot.getStatus().toString());
            preparedStatement.setString(2, prot.getSteps());
            preparedStatement.setInt(3, prot.getTimePlayed());
            preparedStatement.executeUpdate();
        }
        finally {
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
    }

    public boolean updateProtocolStatus(int protocolId, ProtocolStatus status) throws SQLException {
        try {
            Protocol protocol = getProtocolById(protocolId);
            connection = ConnectionFactory.getConnection();
            if(protocol == null)
                return false;
            preparedStatement = connection.prepareCall("UPDATE protocols set status = ? where ID=?");
            preparedStatement.setString(1, status.toString());
            preparedStatement.setInt(2, protocol.getId());
            preparedStatement.execute();
        }
        finally {
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return true;
    }

    public boolean updateProtocolTimePlayed(int protocolId, int timeToAdd) throws SQLException {
        try {
            Protocol protocol = getProtocolById(protocolId);
            connection = ConnectionFactory.getConnection();
            if(protocol == null)
                return false;
            preparedStatement = connection.prepareCall("UPDATE protocols set time_played = ? where ID=?");
            preparedStatement.setInt(1, timeToAdd + protocol.getTimePlayed());
            preparedStatement.setInt(2, protocol.getId());
            preparedStatement.execute();
        }
        finally {
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return true;
    }

    //searchByText
    //searchByField
    //updateProtocol

    public List<Protocol> searchProtocolByText(String searchText) throws SQLException{
        ArrayList<Protocol> result = new ArrayList<Protocol>();
        searchText = "%" + searchText + "%";
        Protocol protocol = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("SELECT * FROM PROTOCOLS WHERE" +
                    "  protocol->>'author' like ? or" +
                    "  protocol->>'authorName' like ? or" +
                    "  protocol->>'averageRating' like ? or" +
                    "  protocol->>'created' like ? or" +
                    "  protocol->>'authorName' like ? or" +
                    "  protocol->>'name' like ? or" +
                    "  protocol->>'status' like ? or" +
                    "  protocol->>'description' like ? or" +
                    "  protocol->>'location' like ?");
            preparedStatement.setString(1, searchText);
            preparedStatement.setString(2, searchText);
            preparedStatement.setString(3, searchText);
            preparedStatement.setString(4, searchText);
            preparedStatement.setString(5, searchText);
            preparedStatement.setString(6, searchText);
            preparedStatement.setString(7, searchText);
            preparedStatement.setString(8, searchText);
            preparedStatement.setString(9, searchText);
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();
            while ( rs.next() ) {
                protocol = convertResultSetToProtocol(rs);
                result.add(protocol);
            }
        }
        finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return result;
    }

    private Protocol convertResultSetToProtocol(ResultSet rs) throws SQLException{
        Protocol protocol = new Protocol();
        while (rs.next()) {
            protocol.setId(rs.getInt("id"));
            protocol.setStatus(ProtocolStatus.valueOf(rs.getString("status").toUpperCase()));
            protocol.setSteps(rs.getString("protocol"));
            protocol.setTimePlayed(rs.getInt("time_played"));
            protocol.setUserId(rs.getInt("user_id"));

            //protocol.setAuthorName(rs.getString("author_name"));
//            protocol.setAverageRating(rs.getFloat("average_rating"));
//            protocol.setCreateDate(rs.getDate("creation_date"));
//            protocol.setDescription(rs.getString("description"));
//            protocol.setLastModifiedDate(rs.getDate("last_modified_date"));
//            protocol.setLocation(rs.getString("location"));
//            protocol.setName(rs.getString("name"));
        }
        return protocol;
    }


    public ArrayList<Protocol> getProtocols() throws SQLException {
        ResultSet rs = null;
        Protocol protocol = null;

        ArrayList<Protocol> protocolList = new ArrayList<Protocol>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from protocols");
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();
            while (rs.next()) {
                protocol = convertResultSetToProtocol(rs);
                protocolList.add(protocol);
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return protocolList;
    }
}

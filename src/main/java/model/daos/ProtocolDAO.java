package model.daos;

import model.beans.*;
import utils.ConnectionFactory;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProtocolDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResearcherDAO researcherDAO = new ResearcherDAO();

    public Protocol getProtocolById(int id) throws SQLException {
        Protocol protocol = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from protocol where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();
            protocol = parseResultSet(rs);
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
            preparedStatement = connection.prepareCall("INSERT INTO protocol (id, status, protocol, time_played) VALUES (nextval('protocols_id_seq'),? ,cast(? as json) ,?)");
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

    public boolean updateProtocolStatus(int protocolId, String status) throws SQLException {
        try {
            Protocol protocol = getProtocolById(protocolId);
            connection = ConnectionFactory.getConnection();
            if(protocol == null)
                return false;
            preparedStatement = connection.prepareCall("UPDATE protocol set status = ? where ID=?");
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
            preparedStatement = connection.prepareCall("UPDATE protocol set time_played = ? where ID=?");
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
            preparedStatement = connection.prepareCall("SELECT * FROM protocol WHERE" +
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
                protocol = parseResultSet(rs);
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

    public List<Protocol> getAllProtocols() throws SQLException {
        ResultSet rs = null;
        Protocol protocol = null;

        List<Protocol> protocolList = new ArrayList<Protocol>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from protocol");
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();

            while (rs.next()) {
                protocol = parseResultSet(rs);
                protocolList.add(protocol);
            }

        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return protocolList;
    }

    private Protocol parseResultSet(ResultSet rs) throws SQLException{
        Protocol protocol = null;
        while (rs.next()) {
            protocol = new Protocol(
                    rs.getInt("id"),
                    researcherDAO.getResearcher(rs.getInt("author")),
                    rs.getString("name"),
                    rs.getString("status"),
                    rs.getString("steps"),
                    rs.getTimestamp("last_modified"),
                    rs.getTimestamp("create_time"),
                    rs.getString("description"),
                    rs.getInt("time_played")
            );

        }
        return protocol;
    }
}

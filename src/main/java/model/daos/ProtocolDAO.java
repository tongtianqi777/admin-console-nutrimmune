package model.daos;

import model.beans.Protocol;
import model.beans.csv.ProtocolCSV;
import org.postgresql.util.PGobject;
import utils.ConnectionFactory;
import utils.DbUtil;

import java.sql.*;
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

            while (rs.next()) {
                protocol = parseResultSet(rs);
            }

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

        List<Protocol> protocolList = new ArrayList<Protocol>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from protocol");
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();

            while (rs.next()) {
                Protocol protocol = parseResultSet(rs);
                protocolList.add(protocol);
            }

            System.out.println("found " + protocolList.size() + " protocols");

        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return protocolList;
    }

    private Protocol parseResultSet(ResultSet rs) throws SQLException{
        Protocol protocol = new Protocol(
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

        return protocol;
    }

    public void importCSV(List<ProtocolCSV> protocolCSVs) throws SQLException {
        try {
            for (ProtocolCSV p : protocolCSVs) {
                if (exist(p.getId())) {
                    update(p);

                } else {
                    insert(p);
                }
            }

        } finally {
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
    }

    private void insert(ProtocolCSV p) throws SQLException {
        PGobject stepsObject = new PGobject();
        stepsObject.setType("json");
        stepsObject.setValue(p.getSteps());

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "insert into protocol values " +
                        "(?, ?, ?, ?, ?, ?, ?, ?, ?);"
        );
        preparedStatement.setInt(1, p.getId());
        preparedStatement.setInt(2, p.getAuthorId());
        preparedStatement.setString(3, p.getName());
        preparedStatement.setString(4, p.getStatus());
        preparedStatement.setObject(5, stepsObject);
        preparedStatement.setTimestamp(6, Timestamp.valueOf(p.getLastModified()));
        preparedStatement.setTimestamp(7, Timestamp.valueOf(p.getCreateTime()));
        preparedStatement.setString(8, p.getDescription());
        preparedStatement.setInt(9, p.getTimePlayed());
        preparedStatement.execute();
    }

    private void update(ProtocolCSV p) throws SQLException {
        PGobject stepsObject = new PGobject();
        stepsObject.setType("json");
        stepsObject.setValue(p.getSteps());

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "update protocol set" +
                        " author = ?," +
                        " name = ?," +
                        " status = ?," +
                        " steps = ?," +
                        " last_modified = ?," +
                        " create_time = ?," +
                        " description = ?," +
                        " time_played = ?" +
                            " where id = ?;"
        );

        preparedStatement.setInt(1, p.getAuthorId());
        preparedStatement.setString(2, p.getName());
        preparedStatement.setString(3, p.getStatus());
        preparedStatement.setObject(4, stepsObject);
        preparedStatement.setTimestamp(5, Timestamp.valueOf(p.getLastModified()));
        preparedStatement.setTimestamp(6, Timestamp.valueOf(p.getCreateTime()));
        preparedStatement.setString(7, p.getDescription());
        preparedStatement.setInt(8, p.getTimePlayed());
        preparedStatement.setInt(9, p.getId());
        preparedStatement.execute();
    }

    private boolean exist(int id) throws SQLException {
        return getProtocolById(id) != null;
    }
}

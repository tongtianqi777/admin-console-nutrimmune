package model.daos;


import model.beans.Community;
import utils.ConnectionFactory;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommunityDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public List<Community> getCommunities () throws SQLException {
        ResultSet rs = null;
        List<Community> communities = new ArrayList<Community>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from community");
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();

            while (rs.next()) {
                Community r = parseResultSet(rs);
                communities.add(r);
            }

        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return communities;
    }

    public Community getCommunity (int id) throws SQLException {
        ResultSet rs = null;
        Community community = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareCall("select * from community where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            rs = preparedStatement.getResultSet();

            while (rs.next()) {
                community = parseResultSet(rs);
            }

        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return community;
    }

    private Community parseResultSet(ResultSet rs) throws SQLException {
        Community c = new Community(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description")
        );

        return c;
    }
}

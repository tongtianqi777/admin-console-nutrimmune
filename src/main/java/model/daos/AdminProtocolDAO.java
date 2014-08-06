package model.daos;

import com.ntm.postgres.ProtocolDAO;
import controller.forms.ProtocolForm;
import utils.ConnectionFactory;

import java.sql.SQLException;


public class AdminProtocolDAO extends ProtocolDAO {

    public void updateProtocol(ProtocolForm form) throws SQLException {

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "update protocols set" +
                        " author = ?," +
                        " clientid = ?," +
                        " description = ?," +
                        " name = ?," +
                        " status = ?," +
                        " location = ?," +
                        " authorname = ?," +
                        " type = ?" +
                        " where id = ?;"
        );
        preparedStatement.setString(1, form.getAuthor());
        preparedStatement.setInt(2, form.getClientID());
        preparedStatement.setString(3, form.getDescription());
        preparedStatement.setString(4, form.getName());
        preparedStatement.setString(5, form.getStatus());
        preparedStatement.setString(6, form.getLocation());
        preparedStatement.setString(7, form.getAuthorName());
        preparedStatement.setString(8, form.getType());
        preparedStatement.setInt(9, form.getId());
        preparedStatement.execute();
    }


    public void delete(int id) throws SQLException {
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "delete from protocols" +
                        " where id = ?;"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }
}

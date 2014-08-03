package model.daos;

import com.ntm.postgres.UserCollabServer;
import com.ntm.postgres.UserDAO;
import controller.forms.ResearcherForm;
import utils.ConnectionFactory;
import utils.DbUtil;

import java.sql.SQLException;
import java.util.List;

public class AdminUserDAO extends UserDAO {

    public void importCSV(List<UserCollabServer> users) throws SQLException {
        try {
            for (UserCollabServer u : users) {
                if (exist(u.getId())) {
                    update(u);

                } else {
                    insert(u);
                }
            }

        } finally {
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
    }

    public void updateResearcher(ResearcherForm form) throws SQLException {
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "update researcher set" +
                        " username = ?," +
                        " password = ?," +
                        " first_name = ?," +
                        " last_name = ?," +
                        " address = ?," +
                        " country = ?," +
                        " phone = ?," +
                        " state = ?," +
                        " zip_code = ?" +
                        " where id = ?;"
        );
        preparedStatement.setString(1, form.getUsername());
        preparedStatement.setString(2, form.getPassword());
        preparedStatement.setString(3, form.getFirstname());
        preparedStatement.setString(4, form.getLastname());
        preparedStatement.setString(5, form.getAddress());
        preparedStatement.setString(6, form.getCountry());
        preparedStatement.setString(7, form.getPhone());
        preparedStatement.setString(8, form.getState());
        preparedStatement.setString(9, form.getZip());
        preparedStatement.setInt(10, form.getId());
        preparedStatement.execute();
    }
}
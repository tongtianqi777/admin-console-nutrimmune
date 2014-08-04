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
                "update users set" +
                        " login = ?," +
                        " address = ?," +
                        " affiliation = ?," +
                        " phone = ?," +
                        " country = ?," +
                        " firstname = ?," +
                        " lastname = ?," +
                        " password = ?," +
                        " state = ?," +
                        " timezone = ?," +
                        " zip = ?," +
                        " token = ?," +
                        " remote = ?," +
                        " status = ?" +
                        " where id = ?;"
        );
        preparedStatement.setString(1, form.getLogin());
        preparedStatement.setString(2, form.getAddress());
        preparedStatement.setString(3, form.getAffiliation());
        preparedStatement.setString(4, form.getPhone());
        preparedStatement.setString(5, form.getCountry());
        preparedStatement.setString(6, form.getFirstname());
        preparedStatement.setString(7, form.getLastname());
        preparedStatement.setString(8, form.getPassword());
        preparedStatement.setString(9, form.getState());
        preparedStatement.setString(10, form.getTimezone());
        preparedStatement.setInt(11, form.getZip());
        preparedStatement.setString(12, form.getToken());
        preparedStatement.setString(13, form.getRemote());
        preparedStatement.setString(14, form.getStatus());
        preparedStatement.setInt(15, form.getId());
        preparedStatement.execute();
    }

    /*
    private int id;
    private String login;
    private String address;
    private String affiliation;
    private String phone;
    private String country;
    private String firstname;
    private String lastname;
    private String password;
    private String state;
    private String timezone;
    private int zip;
    private String token;
    private String remote;
    private String status;
     */
}
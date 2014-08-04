package model.daos;

import com.ntm.postgres.Device;
import com.ntm.postgres.DeviceDAO;
import controller.forms.DeviceForm;
import utils.ConnectionFactory;
import utils.DbUtil;

import java.sql.SQLException;
import java.util.List;


public class AdminDeviceDAO extends DeviceDAO {

    public void importCSV(List<Device> devices) throws SQLException {
        try {
            for (Device d : devices) {
                if (exist(d.getId())) {
                    update(d);

                } else {
                    insert(d);
                }
            }

        } finally {
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
    }

    public void update(DeviceForm form) throws SQLException {
        /*
        private int id;
    private String mac;
    private int osbuildrev;
    private int ownerId;
    private String status;
         */

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "update devices set" +
                        " mac = ?," +
                        " osbuildrev = ?," +
                        " owner_id = ?," +
                        " status = ?" +
                        " where id = ?;"
        );
        preparedStatement.setString(1, form.getMac());
        preparedStatement.setInt(2, form.getOsbuildrev());
        preparedStatement.setInt(3, form.getOwnerId());
        preparedStatement.setString(4, form.getStatus());
        preparedStatement.setInt(5, form.getId());
        preparedStatement.execute();
    }

    public void add(DeviceForm form) throws SQLException {
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "insert into devices (mac, osbuildrev, owner_id, status) values (" +
                        " ?," +
                        " ?," +
                        " ?," +
                        " ? " +
                        ");"
        );
        preparedStatement.setString(1, form.getMac());
        preparedStatement.setInt(2, form.getOsbuildrev());
        preparedStatement.setInt(3, form.getOwnerId());
        preparedStatement.setString(4, form.getStatus());
        preparedStatement.execute();
    }

}



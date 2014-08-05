package model.daos;

import com.ntm.postgres.Device;
import com.ntm.postgres.DeviceDAO;
import controller.forms.DeviceForm;
import utils.ConnectionFactory;
import utils.DataTypeUtils;
import utils.DbUtil;

import java.sql.SQLException;
import java.text.ParseException;
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

    public void update(DeviceForm form) throws SQLException, ParseException {

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "update devices set" +
                        " mac = ?," +
                        " manufacturedate = ?," +
                        " osbuildrev = ?," +
                        " owner_id = ?," +
                        " shipdate = ?," +
                        " status = ?" +
                        " where id = ?;"
        );
        preparedStatement.setString(1, form.getMac());
        preparedStatement.setDate(2, DataTypeUtils.stringToSqlDate(form.getManufactureDate()));
        preparedStatement.setInt(3, form.getOsbuildrev());
        preparedStatement.setInt(4, form.getOwnerId());
        preparedStatement.setDate(5, DataTypeUtils.stringToSqlDate(form.getShipdate()));
        preparedStatement.setString(6, form.getStatus());
        preparedStatement.setInt(7, form.getId());

        preparedStatement.execute();
    }

    public void add(DeviceForm form) throws SQLException, ParseException {
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(
                "insert into devices (mac, manufacturedate, osbuildrev, owner_id, shipdate, status) values (" +
                        " ?," +
                        " ?," +
                        " ?," +
                        " ?," +
                        " ?," +
                        " ? " +
                        ");"
        );
        preparedStatement.setString(1, form.getMac());
        preparedStatement.setDate(2, DataTypeUtils.stringToSqlDate(form.getManufactureDate()));
        preparedStatement.setInt(3, form.getOsbuildrev());
        preparedStatement.setInt(4, form.getOwnerId());
        preparedStatement.setDate(5, DataTypeUtils.stringToSqlDate(form.getShipdate()));
        preparedStatement.setString(6, form.getStatus());
        preparedStatement.execute();
    }


}



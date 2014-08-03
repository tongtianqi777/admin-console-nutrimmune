package model.daos;

import com.ntm.postgres.Device;
import com.ntm.postgres.DeviceDAO;
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

}



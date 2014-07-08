package model.beans;

import config.PosgreSQLConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Author: shim.
 * Creation date: 6/4/14.
 */
public class ConnectionFactory {

//    private final Logger logger = Logger.getLogger(ConnectionFactory.class);

    //static reference to itself
    private static ConnectionFactory instance = new ConnectionFactory();

    //private constructor
    private ConnectionFactory() {
        try {
            Class.forName(PosgreSQLConfig.getPostgresqlLibraryClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//            logger.error(e.getMessage());
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(PosgreSQLConfig.getPostgresqlDbUrl(),
                    PosgreSQLConfig.getPostgresqlDbUser(), PosgreSQLConfig.getPostgresqlDbUserPassword());
        } catch (SQLException e) {
            e.printStackTrace();
//            logger.error(e.getMessage());
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }
}

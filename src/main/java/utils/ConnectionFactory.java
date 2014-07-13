package utils;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    //static reference to itself
    private static ConnectionFactory instance = new ConnectionFactory();

    private static ApplicationContext applicationContext = null;

    private static String postgresqlDbUrl;
    private static String postgresqlDbUser;
    private static String postgresqlDbPassword;
    public static final String POSTGRESQL_LIBRARY_CLASS_NAME = "org.postgresql.Driver";

    //private constructor
    private ConnectionFactory() {
        try {
            Class.forName(POSTGRESQL_LIBRARY_CLASS_NAME);
            applicationContext = ApplicationContextUtils.getApplicationContext();
            DriverManagerDataSource ds = (DriverManagerDataSource) applicationContext.getBean("dataSource");
            postgresqlDbUrl = ds.getUrl();
            postgresqlDbUser = ds.getUsername();
            postgresqlDbPassword = ds.getPassword();

            System.out.println(postgresqlDbUrl + postgresqlDbUser + postgresqlDbPassword);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(postgresqlDbUrl,
                    postgresqlDbUser, postgresqlDbPassword);
            System.out.println("Got a connection: " + postgresqlDbUrl + postgresqlDbUser + postgresqlDbPassword);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("Setting context for connection factory..");
//        this.applicationContext = applicationContext;
//    }
}

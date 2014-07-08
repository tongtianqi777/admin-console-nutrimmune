package config;

/**
 * Author: shim.
 * Creation date: 6/4/14.
 */
public class PosgreSQLConfig {

    //developer specify useLocalDB constant depending on local or remote DB deployment
    private static final boolean useLocalDB = false;

    private static final String POSTGRESQL_LOCAL_DB_URL = "jdbc:postgresql://localhost:5432/NutrimmuneTest";
    private static final String POSTGRESQL_LOCAL_DB_USER = "postgres";
    private static final String POSTGRESQL_LOCAL_DB_USER_PASSWORD = "password";

    private static final String POSTGRESQL_AWS_DB_URL = "jdbc:postgresql://54.198.109.52:5432/nutrimmune";
    private static final String POSTGRESQL_AWS_DB_USER = "postgres";
    private static final String POSTGRESQL_AWS_DB_USER_PASSWORD = "cmunutrimmune";

    private static final String POSTGRESQL_LIBRARY_CLASS_NAME = "org.postgresql.Driver";

    public static String getPostgresqlDbUrl() {
        if(useLocalDB)
            return POSTGRESQL_LOCAL_DB_URL;
        else
            return POSTGRESQL_AWS_DB_URL;
    }

    public static String getPostgresqlDbUser() {
        if(useLocalDB)
            return POSTGRESQL_LOCAL_DB_USER;
        else
            return POSTGRESQL_AWS_DB_USER;
    }

    public static String getPostgresqlDbUserPassword() {
        if(useLocalDB)
            return POSTGRESQL_LOCAL_DB_USER_PASSWORD;
        else
            return POSTGRESQL_AWS_DB_USER_PASSWORD;
    }
    public static String getPostgresqlLibraryClassName() {
        return POSTGRESQL_LIBRARY_CLASS_NAME;
    }
}
